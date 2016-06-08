package csheets.ext.events.ui;

import csheets.domain.Event;
import csheets.ext.events.EventsController;
import csheets.framework.persistence.repositories.DataIntegrityViolationException;
import csheets.support.DateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;

/**
 *
 * @author Rui Bastos
 */
public class ManageEvents extends javax.swing.JPanel implements Observer {

	private final EventsController controller;
	private Event event;
	private List<csheets.domain.Calendar> listCalendar = new ArrayList();

	private final String[] nameMonth = {"Invalid", "January", "Febraury",
		"March", "April", "May", "June",
		"July", "August", "September",
		"October", "November", "December"};

	/**
	 * Creates new form NewJPanel
	 *
	 * @param controller The events controller.
	 * @param event The event.
	 */
	public ManageEvents(EventsController controller, Event event) {
		this.controller = controller;
		this.event = event;
		initComponents();
		initDate();
		initCalendar();
		this.update(null, this.event);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (this.event != null) {
			this.jComboBoxCalendars.setSelectedItem(this.event.calendar());
			this.jComboBoxCalendars.setEnabled(false);
			this.jTextFieldEventName.setText(this.event.description());
			this.cmbYearStart.setSelectedItem(DateTime.year(this.event.
				startDate()));
			this.cmbMonthStart.setSelectedItem(DateTime.month(this.event.
				startDate()));
			this.cmbDayStart.setSelectedItem(DateTime.
				day(this.event.startDate()));
			this.cmbHourStart.setSelectedItem(DateTime.hour(this.event.
				startDate()));
			this.cmbMinuteStart.setSelectedItem(DateTime.min(this.event.
				startDate()));
			this.cmbYearEnd.setSelectedItem(DateTime.year(this.event.
				endDate()));
			this.cmbMonthEnd.setSelectedItem(DateTime.month(this.event.
				endDate()));
			this.cmbDayEnd.setSelectedItem(DateTime.
				day(this.event.endDate()));
			this.cmbHourEnd.setSelectedItem(DateTime.hour(this.event.
				endDate()));
			this.cmbMinuteEnd.setSelectedItem(DateTime.min(this.event.
				endDate()));
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldEventName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxCalendars = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cmbYearStart = new javax.swing.JComboBox();
        cmbMonthStart = new javax.swing.JComboBox();
        cmbDayStart = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        cmbHourStart = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        cmbMinuteStart = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        cmbYearEnd = new javax.swing.JComboBox();
        cmbMonthEnd = new javax.swing.JComboBox();
        cmbDayEnd = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cmbMinuteEnd = new javax.swing.JComboBox();
        cmbHourEnd = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Event Name:");

        jLabel3.setText("Calendar:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldEventName, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxCalendars, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxCalendars, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldEventName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90))
        );

        jLabel6.setText("Start Date:");

        cmbYearStart.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbYearStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbYearStartActionPerformed(evt);
            }
        });

        cmbMonthStart.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbMonthStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMonthStartActionPerformed(evt);
            }
        });

        cmbDayStart.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Hour:");

        cmbHourStart.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setText(":");

        cmbMinuteStart.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbYearStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbMonthStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbDayStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbHourStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbMinuteStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbMonthStart)
                    .addComponent(jLabel7)
                    .addComponent(cmbHourStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbYearStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDayStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cmbMinuteStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jLabel9.setText("End Date:");

        cmbYearEnd.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbYearEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbYearEndActionPerformed(evt);
            }
        });

        cmbMonthEnd.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbMonthEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMonthEndActionPerformed(evt);
            }
        });

        cmbDayEnd.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setText("Hour:");

        jLabel12.setText(":");

        cmbMinuteEnd.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbHourEnd.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbYearEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbMonthEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbDayEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbHourEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbMinuteEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cmbMonthEnd)
                    .addComponent(jLabel10)
                    .addComponent(cmbYearEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDayEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(cmbMinuteEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbHourEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel11.setText(":");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(345, 345, 345)
                    .addComponent(jLabel11)
                    .addContainerGap(319, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(127, 127, 127)
                    .addComponent(jLabel11)
                    .addContainerGap(57, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

	private void initCalendar() {
		for (csheets.domain.Calendar calendar : this.controller.allCalendars()) {
			this.listCalendar.add(calendar);
			this.jComboBoxCalendars.addItem(calendar.toString());
		}
	}

	private void initDate() {
		initYear();
		initMonth();
		initDays();
		initHours();
		initMinutes();
	}

	private void initYear() {
		Calendar calendar = Calendar.getInstance();
		cmbYearStart.removeAllItems();
		cmbYearEnd.removeAllItems();
		int currentYear = calendar.get(Calendar.YEAR);

		for (int yearCount = currentYear; yearCount <= currentYear + 10; yearCount++) {
			cmbYearStart.addItem(yearCount);
			cmbYearEnd.addItem(yearCount);
		}
		cmbYearStart.setSelectedIndex(0);
		cmbYearEnd.setSelectedIndex(0);
	}

	private void initMonth() {
		Calendar calendar = Calendar.getInstance();
		cmbMonthStart.removeAllItems();
		cmbMonthEnd.removeAllItems();
		for (int monthCount = 1; monthCount < 13; monthCount++) {
			cmbMonthStart.addItem(nameMonth[monthCount]);
			cmbMonthEnd.addItem(nameMonth[monthCount]);
		}
		cmbMonthStart.setSelectedIndex(calendar.get(Calendar.MONTH));
		cmbMonthEnd.setSelectedIndex(calendar.get(Calendar.MONTH));
	}

	private void initDays() {
		Calendar calendar = Calendar.getInstance();
		cmbDayStart.removeAllItems();
		cmbDayEnd.removeAllItems();
		calendar.set(Calendar.MONTH, cmbMonthStart.getSelectedIndex());
		calendar.set(Calendar.MONTH, cmbMonthEnd.getSelectedIndex());
		calendar.set(Calendar.YEAR, cmbYearStart.getSelectedIndex());
		calendar.set(Calendar.YEAR, cmbYearEnd.getSelectedIndex());
		int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

		for (int dayCount = 1; dayCount <= lastDay; dayCount++) {
			cmbDayStart.addItem(dayCount);
			cmbDayEnd.addItem(dayCount);
		}
		cmbDayStart.setSelectedIndex(calendar.get(Calendar.DAY_OF_MONTH));
		cmbDayEnd.setSelectedIndex(calendar.get(Calendar.DAY_OF_MONTH));
	}

	private void initHours() {
		Calendar calendar = Calendar.getInstance();
		cmbHourStart.removeAllItems();
		cmbHourEnd.removeAllItems();
		for (int hourCount = 0; hourCount <= 23; hourCount++) {
			cmbHourStart.addItem(hourCount);
			cmbHourEnd.addItem(hourCount);
		}
		cmbHourStart.setSelectedIndex(calendar.get(Calendar.HOUR_OF_DAY));
		cmbHourEnd.setSelectedIndex(calendar.get(Calendar.HOUR_OF_DAY));
	}

	private void initMinutes() {
		Calendar calendar = Calendar.getInstance();
		cmbMinuteStart.removeAllItems();
		cmbMinuteEnd.removeAllItems();
		for (int minuteCount = 0; minuteCount <= 59; minuteCount++) {
			cmbMinuteStart.addItem(minuteCount);
			cmbMinuteEnd.addItem(minuteCount);
		}
		cmbMinuteStart.setSelectedIndex(calendar.get(Calendar.MINUTE));
		cmbMinuteEnd.setSelectedIndex(calendar.get(Calendar.MINUTE));
	}

    private void cmbYearStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbYearStartActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_cmbYearStartActionPerformed

    private void cmbMonthStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMonthStartActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_cmbMonthStartActionPerformed

    private void cmbYearEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbYearEndActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_cmbYearEndActionPerformed

    private void cmbMonthEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMonthEndActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_cmbMonthEndActionPerformed

	public void createEvent() {
		Calendar startDate = DateTime.newCalendar((Integer) (this.cmbYearStart.
			getSelectedItem()), cmbMonthStart.getSelectedIndex() + 1, (Integer) (this.cmbDayStart.
												  getSelectedItem()), (Integer) (this.cmbHourStart.
												  getSelectedItem()),
												  (Integer) (this.cmbMinuteStart.
												  getSelectedItem()), 0);
		Calendar endDate = DateTime.newCalendar((Integer) (this.cmbYearEnd.
			getSelectedItem()), cmbMonthEnd.getSelectedIndex() + 1, (Integer) (this.cmbDayEnd.
												getSelectedItem()), (Integer) (this.cmbHourEnd.
												getSelectedItem()),
												(Integer) (this.cmbMinuteEnd.
												getSelectedItem()), 0);
		if (DateTime.now().before(startDate) || DateTime.now().before(endDate) || startDate.
			after(endDate)) {
			if (this.event == null) {
				try {
					this.controller.
						createEvent((csheets.domain.Calendar) this.listCalendar.
							get(this.jComboBoxCalendars.getSelectedIndex()), this.jTextFieldEventName.
									getText(), startDate, endDate);
				} catch (DataIntegrityViolationException ex) {
					JOptionPane.
						showMessageDialog(null, "Event already exists!", "Event edition", JOptionPane.ERROR_MESSAGE);
				} catch (IllegalArgumentException ex) {
					JOptionPane.
						showMessageDialog(null, "Illegal arguments!", "Event edition", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				this.event.
					defineEvent(this.event.calendar(), this.jTextFieldEventName.
								getText(), startDate, endDate);
				this.controller.editEvent(this.event);
			}
		} else {
			JOptionPane.
				showMessageDialog(this, "Currente date is invalid", "Error", JOptionPane.WARNING_MESSAGE);
		}
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbDayEnd;
    private javax.swing.JComboBox cmbDayStart;
    private javax.swing.JComboBox cmbHourEnd;
    private javax.swing.JComboBox cmbHourStart;
    private javax.swing.JComboBox cmbMinuteEnd;
    private javax.swing.JComboBox cmbMinuteStart;
    private javax.swing.JComboBox cmbMonthEnd;
    private javax.swing.JComboBox cmbMonthStart;
    private javax.swing.JComboBox cmbYearEnd;
    private javax.swing.JComboBox cmbYearStart;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox<String> jComboBoxCalendars;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTextFieldEventName;
    // End of variables declaration//GEN-END:variables
}
