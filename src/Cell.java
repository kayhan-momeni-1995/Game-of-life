import java.awt.Color;
import java.awt.Container;

import javax.swing.JLabel;

public class Cell {

	int x, y, status=0, cellsAround=0;
	JLabel g;
	static int population=0;
	public Cell(int x, int y, int status, Container frm)
	{
		g = new JLabel("");
		g.setOpaque(true);
		this.x=x;
		this.y=y;
		this.status=status;
		if (status == 0)
			g.setBackground(Color.WHITE);
		else
			g.setBackground(Color.black);
		g.setBounds(5+10*x, 5+10*y, 9, 9);
		frm.add(g);
	}
	void setNewStatus(int status)
	{
		this.status=status;
		if (status == 0)
			g.setBackground(Color.WHITE);
		else
			g.setBackground(new Color (0,0,0));
	}

}
