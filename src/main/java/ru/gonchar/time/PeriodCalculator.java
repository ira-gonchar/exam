package ru.gonchar.time;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PeriodCalculator {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculate Period");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel infoPanel = new JPanel();
        JLabel infoLabel = new JLabel("Time Format is 'HH:mm:ss.SSS' or 'hh:mm:ss.SSS aa'");
        infoPanel.add(infoLabel);

        JPanel startTimePanel = new JPanel();
        JLabel startTimeLabel = new JLabel("Start Time");
        JTextField startTimeText = new JTextField(15);
        startTimePanel.add(startTimeLabel);
        startTimePanel.add(startTimeText);

        JPanel endTimePanel = new JPanel();
        JLabel endTimeLabel = new JLabel("End Time");
        JTextField endTimeText = new JTextField(15);
        endTimePanel.add(endTimeLabel);
        endTimePanel.add(endTimeText);

        JPanel resultPanel = new JPanel();
        JLabel resultLabel = new JLabel("");
        resultPanel.add(resultLabel);

        JPanel calcPanel = new JPanel();
        JButton calcButton = new JButton("Calculate Period");
        calcPanel.add(calcButton);

        calcButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String startTime = startTimeText.getText();
                        String endTime = endTimeText.getText();

                        try {
                            AbstractTime start = parseTime(startTime);
                            AbstractTime end = parseTime(endTime);

                            Period period = new Period(start, end);

                            resultLabel.setText(period.getTime());
                        } catch (Exception ex) {
                            resultLabel.setText("Error");
                            ex.printStackTrace();
                        }
                    }

                    private AbstractTime parseTime(String timeStr) {
                        AbstractTime time;
                        if (timeStr.length() > 12) {
                            time = new Time12(timeStr);
                        } else {
                            time = new Time24(timeStr);
                        }
                        return time;
                    }
                }
        );

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        mainPanel.add(infoPanel);
        mainPanel.add(startTimePanel);
        mainPanel.add(endTimePanel);
        mainPanel.add(calcPanel);
        mainPanel.add(resultPanel);

        frame.getContentPane().add(BorderLayout.NORTH, mainPanel);
        frame.setVisible(true);
    }
}
