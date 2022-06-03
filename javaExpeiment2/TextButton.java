package com.javaExpeiment2; /**
 * An extension to JButton that binds the button action to input from a
 * JTextField, and uses a Timer to pause program activity until String returned
 * from JTextField.
 *
 * @author M. Allen
 */

import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class TextButton extends JButton implements ActionListener {
    /* JTextField from which to take and return input. */
    private JTextField text;

    /* Timer used to pause program until text properly entered. */
    private Timer timer;

    /**
     * pre: jtf must be properly initialized.
     * <p>
     * post: text == param jtf and timer initialized, both with this
     * as an ActionListener.
     *
     * @param jtf : a JTextField for input.
     */
    public TextButton(JTextField jtf) {
        super();
        text = jtf;
        text.setText("");
        text.addActionListener(this);
        addActionListener(this);
        timer = new Timer(100, this);
    }

    /**
     * post: JTextField text is empty, and all program activity halts until
     * input has been properly entered, at which point a button press, or
     * enter/return in text field will return.
     *
     * @return non-empty String from text
     */
    public String getInput() {
        timer.start();
        while (timer.isRunning()) {
        }
        timer.start();
        return text.getText();

    }

    /**
     * post: if this button is pressed, or enter/return typed in associated
     * JTextField, and that text-field is not empty, then timer is stopped.
     *
     * @param e : ActionEvent from associated objects
     **/
    public void actionPerformed(ActionEvent e) {
        if (timer.isRunning())
            if (e.getSource() == this || e.getSource() == text)
                if (!text.getText().equals(""))
                    timer.stop();
    }
}
