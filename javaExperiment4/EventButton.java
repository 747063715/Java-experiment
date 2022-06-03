package com.javaExperiment4; /**
 * Author: M. Allen
 *
 * An extension to JButton that binds the button action to a Driver object,
 * which must feature a method called buttonPressed()
 */
import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings( "serial" )
public class EventButton extends JButton implements ActionListener
{
    private UbbiDubbiGenerator generator;
    
    /**
     * pre: Driver d must be instantiated && must contain a method called
     * buttonPressed().
     * post: This button can respond to action events and run the Driver method
     * buttonPressed().
     *
     * @param generator Driver with which this button communicates.
     */
    public EventButton( UbbiDubbiGenerator generator )
    {
        super();
        addActionListener( this );
        this.generator = generator;
    }
    
    /**
     * post: If this button is pressed, the driver method buttonPressed() is
     * called to respond to the button presss event.
     *
     * @param e : ActionEvent from associated objects
     */
    public void actionPerformed( ActionEvent e )
    {
        generator.buttonPressed();
    }
}
