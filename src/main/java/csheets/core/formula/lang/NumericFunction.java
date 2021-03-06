/*
 * Copyright (c) 2005 Einar Pehrson <einar@pehrson.nu>.
 *
 * This file is part of
 * CleanSheets - a spreadsheet application for the Java platform.
 *
 * CleanSheets is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * CleanSheets is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CleanSheets; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package csheets.core.formula.lang;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.Expression;
import csheets.core.formula.Function;
import csheets.core.formula.FunctionParameter;

/**
 * A numeric function that invokes a method object.
 *
 * @author Einar Pehrson
 */
public class NumericFunction implements Function {

    /**
     * The method that the function invokes
     */
    private Method method;

    /**
     * Creates a new math reflection function.
     *
     * @param method method
     */
    public NumericFunction(Method method) {
        this.method = method;
    }

    public String getIdentifier() {
        return method.getName().toUpperCase();
    }

    public Value applyTo(Expression[] arguments) throws IllegalValueTypeException {
        // Fetches values
        double[] values = new double[arguments.length];
        for (int i = 0; i < arguments.length; i++) {
            values[i] = arguments[i].evaluate().toDouble();
        }

        // Invokes method
        try {
            if (values.length == 0) {
                return new Value((Number) method.invoke(null));
            } else if (values.length == 1) {
                return new Value((Number) method.invoke(null, values[0]));
            } else if (values.length == 2) {
                return new Value((Number) method.invoke(null, values[0], values[1]));
            } else {
                return new Value((Number) method.invoke(null, values[0], values[1], values[2]));
            }
        } catch (IllegalAccessException e) {
            return new Value(e);
        } catch (IllegalArgumentException e) {
            return new Value(e);
        } catch (InvocationTargetException e) {
            return new Value(e);
        }
    }

    public FunctionParameter[] getParameters() {
        Class[] paramTypes = method.getParameterTypes();
        FunctionParameter[] params = new FunctionParameter[paramTypes.length];
        for (int i = 0; i < paramTypes.length; i++) {
            params[i] = new FunctionParameter(Value.Type.NUMERIC, "Parameter " + i, false, "Unknown");
        }
        return params;
    }

    public boolean isVarArg() {
        return method.isVarArgs();
    }

    /**
     * Gets the description of the function
     *
     * @return function description
     */
    @Override
    public String getDescription() {
        return "A numeric function that invokes a method object.";
    }

    /**
     * Return template of the function
     *
     * @return function template
     */
    @Override
    public String getTemplate() {
        String result = "={" + getIdentifier() + "(";
        FunctionParameter[] param = getParameters();
        for (int i = 0; i < param.length; i++) {
            if (i != 0) {
                result += ";";
            }
            result += param[i].getValueType().toString();
        }
        result += ")}";
        return result;
    }
}
