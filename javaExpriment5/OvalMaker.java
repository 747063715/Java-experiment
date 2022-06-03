package com.javaExpriment5; /**
 * This program creates Oval objects on-screen, either based upon user input, or
 * randomly as a set of circles.
 *
 * @author M. Allen
 */
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class OvalMaker implements ActionListener
{
    // graphical elements
    private JFrame mainWindow;
    private JTextField xField, yField, widthField, heightField;
    private JButton addButton, randButton;

    /**
     * Simple main() to start program.
     * 
     * @param args Not used.
     */
    public static void main( String[] args )
    {
        OvalMaker maker = new OvalMaker();
        maker.makeWindows();
    }

    /**
     * Create two windows: one for displaying shapes,
     * and one for obtaining user input.
     */
    private void makeWindows()
    {
        mainWindow = new JFrame();
        mainWindow.setLayout( null );
        mainWindow.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        mainWindow.setTitle( "Shapely Shapes" );
        mainWindow.setLocation( 50, 50 );
        mainWindow.setSize( 500, 500 );
        mainWindow.setResizable( false );
        mainWindow.setVisible( true );
        mainWindow.getContentPane().setBackground( Color.white );

        JFrame inputWindow = new JFrame();
        inputWindow.setLayout( null );
        inputWindow.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        inputWindow.setLocation( mainWindow.getX(),
                                 mainWindow.getY() + mainWindow.getHeight() + 10 );
        inputWindow.setVisible( true );
        inputWindow.setSize( mainWindow.getWidth(),
                             100 + inputWindow.getInsets().top + inputWindow.getInsets().bottom );
        inputWindow.setResizable( false );
        inputWindow.getContentPane().setBackground( Color.lightGray );

        int fieldWidth = 100;
        int fieldHeight = 20;
        JLabel xLabel = new JLabel( "x:" );
        xLabel.setHorizontalAlignment( JLabel.RIGHT );
        xLabel.setBounds( 75, 10, 40, fieldHeight );
        inputWindow.add( xLabel, 0 );

        xField = new JTextField();
        xField.setBounds( 125, 10, fieldWidth, fieldHeight );
        xField.setBackground( Color.white );
        xField.setOpaque( true );
        inputWindow.add( xField, 0 );

        JLabel yLabel = new JLabel( "y:" );
        yLabel.setHorizontalAlignment( JLabel.RIGHT );
        yLabel.setBounds( 75, 40, 40, fieldHeight );
        inputWindow.add( yLabel, 0 );

        yField = new JTextField();
        yField.setBounds( 125, 40, fieldWidth, fieldHeight );
        yField.setBackground( Color.white );
        yField.setOpaque( true );
        inputWindow.add( yField, 0 );

        JLabel wLabel = new JLabel( "w:" );
        wLabel.setHorizontalAlignment( JLabel.RIGHT );
        wLabel.setBounds( 275, 10, 40, fieldHeight );
        inputWindow.add( wLabel, 0 );

        widthField = new JTextField();
        widthField.setBounds( 325, 10, fieldWidth, fieldHeight );
        widthField.setBackground( Color.white );
        widthField.setOpaque( true );
        inputWindow.add( widthField, 0 );

        JLabel hLabel = new JLabel( "h:" );
        hLabel.setHorizontalAlignment( JLabel.RIGHT );
        hLabel.setBounds( 275, 40, 40, fieldHeight );
        inputWindow.add( hLabel, 0 );

        heightField = new JTextField();
        heightField.setBounds( 325, 40, fieldWidth, fieldHeight );
        heightField.setBackground( Color.white );
        heightField.setOpaque( true );
        inputWindow.add( heightField, 0 );

        addButton = new JButton( "Add" );
        addButton.setBounds( inputWindow.getWidth() / 2 - ( fieldWidth + 10 ),
                             heightField.getY() + fieldHeight + 10, fieldWidth,
                             fieldHeight );
        addButton.addActionListener( this );
        inputWindow.add( addButton, 0 );

        randButton = new JButton( "Rand" );
        randButton.setBounds( inputWindow.getWidth() / 2 + 10,
                              heightField.getY() + fieldHeight + 10, fieldWidth,
                              fieldHeight );
        randButton.addActionListener( this );
        inputWindow.add( randButton, 0 );

        mainWindow.repaint();
        inputWindow.repaint();
    }


    //首先编写一个名为 getNumber（）的辅助方法，以便获取用户四个文本框的数字。
    private int getNumber( JTextField field )
    {
        int number = 0;
        try
        {
            number = Integer.parseInt( field.getText() );
        }
        catch ( NumberFormatException e )
        {
            JOptionPane.showMessageDialog( mainWindow, "Invalid number", "Error", JOptionPane.ERROR_MESSAGE );

        }
        return number;
    }


    private Color getRandomColor()
    {
        int red = (int) ( Math.random() * 256 );
        int green = (int) ( Math.random() * 256 );
        int blue = (int) ( Math.random() * 256 );
        return new Color( red, green, blue );
    }


    private void addOval(int x, int y, int width, int height)
    {
        Oval oval = new Oval( x, y, width, height );
        //调用getRandomColor()随机设置oval的颜色，并将其加入到mainWindow的内容面板中。
        oval.setBackground(getRandomColor());
        mainWindow.add( oval );
        mainWindow.repaint();
    }



    /**
     * Adds a single Oval to main window, based upon location and size values
     * given by user. Color is chosen randomly.
     */
    //获取四个不同文本框中的四个值，分别对应将要生成的椭圆的左上角坐标(x,y)和长、宽数据
    private void addOneOval() {
        int x = getNumber( xField );
        int y = getNumber( yField );
        int width = getNumber( widthField );
        int height = getNumber( heightField );
        //调用addOval()方法，生成椭圆
        addOval( x, y, width, height);
    }



    private void addRandomCircles()
    {
        int number = (int) ( Math.random() * 10 ) + 1;
        for ( int i = 0; i < number; i++ )
        {
            int x = (int) ( Math.random() * ( mainWindow.getWidth() - 100 ) );
            int y = (int) ( Math.random() * ( mainWindow.getHeight() - 100 ) );
            int width = (int) ( Math.random() * 100 ) + 50;
            int height = width;

       addOval( x, y, width, height);
        }
    }

    /**
     * Called whenever button is pressed; calling a method to generate shapes
     * based on user input.
     * 
     * @param e The event caused by pressing some button or other.
     */
    //修改 actionPerformed（）方法，使用 e.getSource()判断事件
    //来源，以便在按下“Rand” 按钮时调用此新方法
    public void actionPerformed( ActionEvent e )
    {
        if ( e.getSource() == addButton )
        {
            addOneOval();
        }
        else if ( e.getSource() == randButton )
        {
            addRandomCircles();
        }
    }
}
