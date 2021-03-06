/**
 * 
 */
package icfs.calendar;

/**
 * @author NOT OURS, GOT IT FROM http://stackoverflow.com/questions/17232038/calendar-display-using-java-swing
 * 
 * 
 * I just changed all the colors of the calendar so that they matched our app
 *
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import moon.Academy;

public class MonthPanel extends JPanel {

    private static final long   serialVersionUID    = 1L;

    protected int               month;
    protected int               year;

    protected String[]          monthNames          = { "January", "February",
            "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December"       };

    protected String[]          dayNames            = { "S", "M", "T", "W",
            "T", "F", "S"                           };

    public MonthPanel(int month, int year) {
        this.month = month;
        this.year = year;

        this.add(createGUI());
    }

    protected JPanel createGUI() {
        JPanel monthPanel = new JPanel(true);
        monthPanel.setBorder(BorderFactory
                .createLineBorder(Academy.DARK_GREEN));
        monthPanel.setLayout(new BorderLayout());
        monthPanel.setBackground(Academy.ORANGE);
        monthPanel.setForeground(Academy.DARK_GREEN);
        monthPanel.add(createTitleGUI(), BorderLayout.NORTH);
        monthPanel.add(createDaysGUI(), BorderLayout.SOUTH);

        return monthPanel;
    }

    protected JPanel createTitleGUI() {
        JPanel titlePanel = new JPanel(true);
        titlePanel.setBorder(BorderFactory
                .createLineBorder(Academy.DARK_GREEN));
        titlePanel.setLayout(new FlowLayout());
        titlePanel.setBackground(Academy.LIGHT_GREEN);

        JLabel label = new JLabel(monthNames[month] + " " + year);
        label.setForeground(Color.BLACK);

        titlePanel.add(label, BorderLayout.CENTER);

        return titlePanel;
    }

    protected JPanel createDaysGUI() {
        JPanel dayPanel = new JPanel(true);
        dayPanel.setLayout(new GridLayout(0, dayNames.length));

        Calendar today = Calendar.getInstance();
        int tMonth = today.get(Calendar.MONTH);
        int tYear = today.get(Calendar.YEAR);
        int tDay = today.get(Calendar.DAY_OF_MONTH);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        Calendar iterator = (Calendar) calendar.clone();
        iterator.add(Calendar.DAY_OF_MONTH,
                -(iterator.get(Calendar.DAY_OF_WEEK) - 1));

        Calendar maximum = (Calendar) calendar.clone();
        maximum.add(Calendar.MONTH, +1);

        for (int i = 0; i < dayNames.length; i++) {
            JPanel dPanel = new JPanel(true);
            dPanel.setBorder(BorderFactory.createLineBorder(Academy.DARK_GREEN));
            JLabel dLabel = new JLabel(dayNames[i]);
            dPanel.add(dLabel);
            dayPanel.add(dPanel);
        }

        int count = 0;
        int limit = dayNames.length * 6;

        while (iterator.getTimeInMillis() < maximum.getTimeInMillis()) {
            int lMonth = iterator.get(Calendar.MONTH);
            int lYear = iterator.get(Calendar.YEAR);

            JPanel dPanel = new JPanel(true);
            dPanel.setBorder(BorderFactory.createLineBorder(Academy.DARK_GREEN));
            JLabel dayLabel = new JLabel();

            if ((lMonth == month) && (lYear == year)) {
                int lDay = iterator.get(Calendar.DAY_OF_MONTH);
                dayLabel.setText(Integer.toString(lDay));
                if ((tMonth == month) && (tYear == year) && (tDay == lDay)) {
                    dPanel.setBackground(Academy.ORANGE);
                } else {
                    dPanel.setBackground(Academy.LIGHT_GREEN);
                }
            } else {
                dayLabel.setText(" ");
                dPanel.setBackground(Academy.LIGHT_GREEN);
            }
            dPanel.add(dayLabel);
            dayPanel.add(dPanel);
            iterator.add(Calendar.DAY_OF_YEAR, +1);
            count++;
        }

        for (int i = count; i < limit; i++) {
            JPanel dPanel = new JPanel(true);
            dPanel.setBorder(BorderFactory.createLineBorder(Academy.DARK_GREEN));
            JLabel dayLabel = new JLabel();
            dayLabel.setText(" ");
            dPanel.setBackground(Academy.LIGHT_GREEN);
            dPanel.add(dayLabel);
            dayPanel.add(dPanel);
        }

        return dayPanel;
    }

}