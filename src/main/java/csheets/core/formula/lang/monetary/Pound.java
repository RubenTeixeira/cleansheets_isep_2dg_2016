package csheets.core.formula.lang.monetary;

import csheets.AppSettings;
import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.Expression;
import csheets.core.formula.Function;
import csheets.core.formula.FunctionParameter;

/**
 * This Function returns a Numeric type value with Pound currency basead on
 * value passed as argument.
 *
 * In this case, this function applies a convertion Euro->Pound.
 *
 * @author Rui Freitas <1130303@isep.ipp.pt>
 */
public class Pound implements Function {

	/**
	 * The only (but repeatable) parameter: a numeric term
	 */
	public static final FunctionParameter[] parameters = new FunctionParameter[]{
		new FunctionParameter(Value.Type.MONEY, "Term", false,
							  "A number to be converted to pound")
	};

	/**
	 * Creates a new instance of the POUND function.
	 */
	public Pound() {
	}

	@Override
	public String getIdentifier() {
		return "pound";
	}

	/**
	 * Returns a Numeric type Value. In this case, a conversion from Euro to
	 * Pound is applied.
	 *
	 * @param arguments
	 * @return
	 * @throws IllegalValueTypeException
	 */
	@Override
	public Value applyTo(Expression[] arguments) throws IllegalValueTypeException {
		return new Value(arguments[0].evaluate().toMoney().multiply(AppSettings.
			instance().
			getEuroToPoundExchangeRate().amount()).amount());
	}

	@Override
	public FunctionParameter[] getParameters() {
		return parameters;
	}

	@Override
	public boolean isVarArg() {
		return false;
	}
}
