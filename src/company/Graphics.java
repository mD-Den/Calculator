package company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.AttributedCharacterIterator;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Map;

class MyJButton extends JButton {

    public MyJButton(String text) {
        super(text);
        this.setFont(new Font("Arial", Font.BOLD, 40));
    }

    @Override
    protected void paintBorder(java.awt.Graphics g) {
        g.drawRoundRect(0, 0, getSize().width - 1, getSize().height - 1, 13, 13);
    }
}

public class Graphics extends Thread {

    private JFrame frame;
    private JPanel panelOne;
    private JPanel panelTwo;
    private JTextField textField;
    double one = Integer.MIN_VALUE;
    double two = Integer.MIN_VALUE;
    double three = 0;
    String str;
    double div;
    MathActivity mathActivity = MathActivity.NONE;
    ArrayList<Double> arrayList = new ArrayList<>();

    public void go() {

        frame = new JFrame("Калькулятор");
        panelOne = new JPanel();
        panelTwo = new JPanel(new GridLayout(1, 7));

        GridLayout layout = new GridLayout(6, 4, 3, 3);
        panelOne.setLayout(layout);

        Font font = new Font("Arial", Font.BOLD, 77);
        Color color = new Color(255, 150, 130);
        Color color1 = new Color(238, 130, 238);
        Color color2 = new Color(147, 112, 219);

        DecimalFormat decimalFormat = new DecimalFormat("#.#########");
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
        symbols.setDecimalSeparator('.');
        decimalFormat.setDecimalFormatSymbols(symbols);

        DecimalFormat df = new DecimalFormat("#.");
        DecimalFormatSymbols sym = DecimalFormatSymbols.getInstance();
        sym.setDecimalSeparator('.');
        df.setDecimalFormatSymbols(sym);

        textField = new JTextField("0", 10);
        textField.selectAll();
        textField.requestFocus();
        textField.setFont(font);
        textField.setBackground(color1);

        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        panelTwo.add(textField);

        MyJButton button21 = new MyJButton("0");
        button21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                str = textField.getText();
                if (str.equals("0")) {
                    textField.setText("0");
                } else {
                    textField.setText(textField.getText() + "0");
                }

            }
        });

        MyJButton button16 = new MyJButton("1");
        button16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                str = textField.getText();
                if (str.equals("0")) {
                    textField.setText("1");
                } else {
                    textField.setText(textField.getText() + "1");
                }
            }
        });

        MyJButton button17 = new MyJButton("2");
        button17.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                str = textField.getText();
                if (str.equals("0")) {
                    textField.setText("2");
                } else {
                    textField.setText(textField.getText() + "2");
                }
            }
        });

        MyJButton button18 = new MyJButton("3");
        button18.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                str = textField.getText();
                if (str.equals("0")) {
                    textField.setText("3");
                } else {
                    textField.setText(textField.getText() + "3");
                }

            }
        });

        MyJButton button12 = new MyJButton("4");
        button12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                str = textField.getText();
                if (str.equals("0")) {
                    textField.setText("4");
                } else {
                    textField.setText(textField.getText() + "4");
                }
            }
        });

        MyJButton button13 = new MyJButton("5");
        button13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                str = textField.getText();
                if (str.equals("0")) {
                    textField.setText("5");
                } else {
                    textField.setText(textField.getText() + "5");
                }
            }
        });

        MyJButton button14 = new MyJButton("6");
        button14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                str = textField.getText();
                if (str.equals("0")) {
                    textField.setText("6");
                } else {
                    textField.setText(textField.getText() + "6");
                }
            }
        });

        MyJButton button8 = new MyJButton("7");
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                str = textField.getText();
                if (str.equals("0")) {
                    textField.setText("7");
                } else {
                    textField.setText(textField.getText() + "7");
                }
            }
        });

        MyJButton button9 = new MyJButton("8");
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                str = textField.getText();
                if (str.equals("0")) {
                    textField.setText("8");
                } else {
                    textField.setText(textField.getText() + "8");
                }
            }
        });

        MyJButton button10 = new MyJButton("9");
        button10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                str = textField.getText();
                if (str.equals("0")) {
                    textField.setText("9");
                } else {
                    textField.setText(textField.getText() + "9");
                }
            }
        });


        MyJButton button0 = new MyJButton("%");
        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arrayList.add(Double.parseDouble(textField.getText()));
                switch (mathActivity) {
                    case PLUS -> three = arrayList.get(arrayList.size() - 2) + (arrayList.get(arrayList.size() - 2) / 100) * arrayList.get(arrayList.size() - 1);
                    case MINUS -> three = arrayList.get(arrayList.size() - 2) - (arrayList.get(arrayList.size() - 2) / 100) * arrayList.get(arrayList.size() - 1);
                    case DIVISION -> {
                        three = (arrayList.get(arrayList.size() - 2)) / ((arrayList.get(arrayList.size() - 1)) / 100);
                        if (Double.isInfinite(three)) {
                            three = 0.0;
                        }
                    }
                    case MULTIPLICATION -> three = (arrayList.get(arrayList.size() - 2)) * (arrayList.get(arrayList.size() - 1) / 100);
                    case NONE -> three = arrayList.get(arrayList.size() - 1) / 100;

                }
                textField.setText(decimalFormat.format(three));
            }
        });

        MyJButton button1 = new MyJButton("CE");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("0");
            }
        });

        MyJButton button2 = new MyJButton("C");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("0");
            }
        });

        MyJButton button3 = new MyJButton("Del");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = textField.getText();
                s = s.substring(0, s.length() - 1);
                if (s.length() == 0) {
                    textField.setText("0");
                } else {
                    textField.setText(s);
                }

            }
        });
        MyJButton button4 = new MyJButton("1/x");
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                two = Double.parseDouble(textField.getText());
                try {
                    div = 1 / two;
                    System.out.println(1 / two);
                    textField.setText(decimalFormat.format(div));
                } catch (ArithmeticException ex) {
                    textField.setText("0");
                }
            }
        });

        MyJButton button5 = new MyJButton("x^2");
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                one = Double.parseDouble(textField.getText());
                textField.setText(decimalFormat.format(one * one));
                panelTwo.repaint();
            }
        });

        MyJButton button6 = new MyJButton('√' + "x");
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double sqrt = Math.sqrt(Integer.parseInt(textField.getText()));
                textField.setText(decimalFormat.format(sqrt));
                panelTwo.repaint();

            }
        });

        MyJButton button7 = new MyJButton("" + '÷');
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mathActivity = MathActivity.DIVISION;
                arrayList.add(Double.parseDouble(textField.getText()));
                textField.setText("0");
                textField.selectAll();
                textField.requestFocus();
            }
        });

        MyJButton button11 = new MyJButton("" + '×');
        button11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mathActivity = MathActivity.MULTIPLICATION;
                arrayList.add(Double.parseDouble(textField.getText()));
                textField.setText("0");
                textField.selectAll();
                textField.requestFocus();
            }
        });

        MyJButton button15 = new MyJButton("" + '−');
        button15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mathActivity = MathActivity.MINUS;
                arrayList.add(Double.parseDouble(textField.getText()));
                textField.setText("0");
                textField.selectAll();
                textField.requestFocus();
            }
        });

        MyJButton button19 = new MyJButton("" + '+');
        button19.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mathActivity = MathActivity.PLUS;
                arrayList.add(Double.parseDouble(textField.getText()));
                textField.setText("0");
                textField.selectAll();
                textField.requestFocus();
            }
        });

        MyJButton button20 = new MyJButton("+/-");
        button20.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                one = Double.parseDouble(textField.getText());
                textField.setText(decimalFormat.format(one * (-1)));
            }
        });

        MyJButton button22 = new MyJButton("" + ',');
        button22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = textField.getText();
                Double d = Double.parseDouble(s);
                textField.setText(df.format(d));
            }
        });

        MyJButton button23 = new MyJButton("" + '=');
        button23.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arrayList.add(Double.parseDouble(textField.getText()));
                switch (mathActivity) {
                    case PLUS -> three = arrayList.get(arrayList.size() - 2) + arrayList.get(arrayList.size() - 1);
                    case MINUS -> three = arrayList.get(arrayList.size() - 2) - arrayList.get(arrayList.size() - 1);
                    case DIVISION -> {
                        three = arrayList.get(arrayList.size() - 2) / arrayList.get(arrayList.size() - 1);
                        if (Double.isInfinite(three)) {
                            three = 0.0;
                        }
                    }
                    case MULTIPLICATION -> three = arrayList.get(arrayList.size() - 2) * arrayList.get(arrayList.size() - 1);
                }
                textField.setText(decimalFormat.format(three));

            }
        });

        button8.setBackground(color1);
        button9.setBackground(color1);
        button10.setBackground(color1);
        button12.setBackground(color1);
        button13.setBackground(color1);
        button14.setBackground(color1);
        button16.setBackground(color1);
        button17.setBackground(color1);
        button18.setBackground(color1);
        button21.setBackground(color1);

        button23.setBackground(color1);

        button0.setBackground(color2);
        button1.setBackground(color2);
        button2.setBackground(color2);
        button3.setBackground(color2);
        button4.setBackground(color2);
        button5.setBackground(color2);
        button6.setBackground(color2);
        button7.setBackground(color2);
        button11.setBackground(color2);
        button15.setBackground(color2);
        button20.setBackground(color2);
        button19.setBackground(color2);
        button22.setBackground(color2);

        panelOne.add(button0);
        panelOne.add(button1);
        panelOne.add(button2);
        panelOne.add(button3);
        panelOne.add(button4);
        panelOne.add(button5);
        panelOne.add(button6);
        panelOne.add(button7);
        panelOne.add(button8);
        panelOne.add(button9);
        panelOne.add(button10);
        panelOne.add(button11);
        panelOne.add(button12);
        panelOne.add(button13);
        panelOne.add(button14);
        panelOne.add(button15);
        panelOne.add(button16);
        panelOne.add(button17);
        panelOne.add(button18);
        panelOne.add(button19);
        panelOne.add(button20);
        panelOne.add(button21);
        panelOne.add(button22);
        panelOne.add(button23);

        frame.getContentPane().add(panelOne);
        frame.getContentPane().add(BorderLayout.NORTH, panelTwo);

        frame.setSize(600, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}





