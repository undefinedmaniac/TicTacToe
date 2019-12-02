package app;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.InputStream;

import javax.swing.JComponent;
import javax.swing.JPanel;

class TicTacToeFontProvider
{
    private static Font _font = null;
    private static Font _font_bold = null;

    public static Font getFont()
    {
        if (_font == null) {
            try {
                InputStream stream = TicTacToeFontProvider.class.getResourceAsStream("Inconsolata-Regular.ttf");
                _font = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(Font.PLAIN, 12);
                stream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return _font;
    }

    public static Font getBoldFont()
    {
        if (_font_bold == null)
            _font_bold = getFont().deriveFont(Font.BOLD);

        return _font_bold;
    }
}

public class TicTacToeBoard extends JPanel 
{
    private int[][] _board_data = new int[3][3];
    private JComponent[][] _components = new JComponent[3][3];

    public TicTacToeBoard() 
    {
        setBackground(Color.BLACK);
        setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                JComponent button = new TicTacToeButton(x, y, _board_data);

                _components[x][y] = button;
                _board_data[x][y] = (x == y ? 2 : 1);

                constraints.gridx = x;
                constraints.gridy = y;

                add(button, constraints);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.WHITE);
        g2.setFont(TicTacToeFontProvider.getFont());
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        int fontHeight = g2.getFontMetrics().getHeight() / 2;
        int fontWidth = g2.getFontMetrics().charWidth(' ');

        updateLayoutSpacing(fontHeight, fontWidth);

        int buttonHeight = _components[0][0].getHeight() + fontHeight;
        int buttonWidth = _components[0][0].getWidth() + fontWidth;

        for (int y = fontHeight; y <= buttonHeight * 3 + fontHeight; y += buttonHeight)
            for (int x = 0; x < getWidth(); x += fontWidth * 2)
                g2.drawString("=", x, y);

        for (int x = 0; x <= buttonWidth * 3; x += buttonWidth)
            for (int y = 0; y < getHeight(); y += fontHeight * 2)
                g2.drawString("|", x, y);
    }

    private void updateLayoutSpacing(int verticalSpacing, int horizontalSpacing)
    {
        int halfVerticalSpacing = verticalSpacing / 2;
        int halfHorizontalSpacing = horizontalSpacing / 2;

        GridBagLayout layout = (GridBagLayout) getLayout();

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                int top = halfVerticalSpacing;
                int bottom = halfVerticalSpacing;
                int left = halfHorizontalSpacing;
                int right = halfHorizontalSpacing;

                if (x == 0)
                    left = horizontalSpacing;
                else if (x == 2)
                    right = horizontalSpacing;

                if (y == 0)
                    top = verticalSpacing;
                else if (y == 2)
                    bottom = verticalSpacing;

                JComponent component = _components[x][y];

                GridBagConstraints constraints = layout.getConstraints(component);
                constraints.insets = new Insets(top, left, bottom, right);

                layout.setConstraints(component, constraints);
            }
        }

        revalidate();
    }
}

class TicTacToeButton extends JComponent implements MouseListener 
{
    private final static String _x_text = "           \n"
                                        + "  \\     /  \n"
                                        + "   \\   /   \n"
                                        + "    \\ /    \n"
                                        + "     \\     \n"
                                        + "    / \\    \n"
                                        + "   /   \\   \n"
                                        + "  /     \\  \n"
                                        + "           ";
    private final static String _o_text = "    ___    \n"
                                        + "   /   \\   \n"
                                        + "  /     \\  \n"
                                        + "  |     |  \n"
                                        + "  |     |  \n"
                                        + "  |     |  \n"
                                        + "  \\     /  \n"
                                        + "   \\___/   \n"
                                        + "           ";

    private Font _current_font = TicTacToeFontProvider.getFont();
    private int _x_pos, _y_pos;
    private int[][] _board_data;

    public TicTacToeButton(int x_pos, int y_pos, int[][] board_data) 
    {
        _x_pos = x_pos;
        _y_pos = y_pos;
        _board_data = board_data;

        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        //g2.setColor(Color.GRAY);
        //g2.fillRect(0, 0, getWidth(), getHeight());

        g2.setColor(Color.WHITE);
        g2.setFont(_current_font);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        String symbolToDraw;

        switch (_board_data[_x_pos][_y_pos])
        {
            case 1:
                symbolToDraw = _x_text;
                break;
            case 2:
                symbolToDraw = _o_text;
                break;
            default:
                symbolToDraw = "";
                break;
        }

        String[] lines = symbolToDraw.split("\n");

        int lineHeight = g2.getFontMetrics().getHeight();

        int symbolWidth = g2.getFontMetrics().stringWidth(lines[0]);
        int symbolHeight = lineHeight * lines.length;

        int x = (getWidth() - symbolWidth) / 2;
        int y = (getHeight() - symbolHeight) / 2;
        for (String line : lines)
            g2.drawString(line, x, y += lineHeight);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) 
    {
        if (!contains(e.getPoint()))
            return;

        int current_value = _board_data[_x_pos][_y_pos];

        if (current_value >= 2)
            _board_data[_x_pos][_y_pos] = 0;
        else
            _board_data[_x_pos][_y_pos]++;

        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) 
    {
        _current_font = TicTacToeFontProvider.getBoldFont();;
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) 
    {
        _current_font = TicTacToeFontProvider.getFont();
        repaint();
    }
}