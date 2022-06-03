package com.javaExpriment3; /**
 * An extension to JButton that binds the button action to a CipherEngine object,
 * which must feature a method called buttonPressed().
 *
 * @author M. Allen
 */
import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings( "serial" )
public class EventButton extends JButton implements ActionListener
{
    private CipherEngine engine;
    
    /**
     * pre: CipherEngine ce must be instantiated && must contain a method called
     * buttonPressed().
     * post: This button can respond to action events and run the CipherEngine method
     * buttonPressed().
     *
     * @param ce CipherEngine with which this button communicates.
     */
    public EventButton( CipherEngine ce )
    {
        super();
        addActionListener( this );
        engine = ce;
    }
    
    /**
     * post: If this button is pressed, the engine method buttonPressed() is
     * called to respond to the button presss event.
     *
     * @param e : ActionEvent from associated objects
     */
    public void actionPerformed( ActionEvent e )
    {
        engine.buttonPressed();
    }
}
