import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;


@SuppressWarnings("serial")
public class Chaos extends JFrame {
	static Cell[][] cells = new Cell[20][20];
	static int[][] iAndJ = new int[2][400];

	//initialize the life!
	static int board [][] ={
			    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
			};
	public static void fillTheBoard(Container frm)
	{
		//random_board();
		for (int i=0; i<20; i++)
		{
			for (int j=0; j<20; j++)
			{
				cells[i][j] = new Cell(i, j,0, frm);
			}
		}
		for (int i=0; i<20; i++)
		{
			for (int j=0; j<20; j++)
			{
				cellUpdater(i, j, 0, board[j][i]);
			}
		}
		
	}
	public static void random_board()
	{
		for (int i=0; i<20; i++)
		{
			for (int j=0; j<20; j++)
			{
				if (Math.random()<0.5)
					board[i][j] = 0;
				else
					board[i][j] = 1;
			}
		}
	}
	public static void cellUpdater(int i, int j, int prvStatus, int newStatus)
	{
		if (prvStatus==newStatus)
			return;
		else
		{
				if (newStatus==1)
				{
					Cell.population++;
					if (i>0)
					{
						if (j>0)
							cells[i-1][j-1].cellsAround++;
						cells[i-1][j].cellsAround++;
						if (j<19)
							cells[i-1][j+1].cellsAround++;
					}
					if (j>0)
						cells[i][j-1].cellsAround++;
					if (j<19)
						cells[i][j+1].cellsAround++;
					if (i<19)
					{
						if (j>0)
							cells[i+1][j-1].cellsAround++;
						cells[i+1][j].cellsAround++;
						if (j<19)
							cells[i+1][j+1].cellsAround++;
					}
				}
				else
				{
					Cell.population--;
					if (i!=0)
					{
						if (j!=0)
							cells[i-1][j-1].cellsAround--;
						cells[i-1][j].cellsAround--;
						if (j!=19)
							cells[i-1][j+1].cellsAround--;
					}
					if (j!=0)
						cells[i][j-1].cellsAround--;
					if (j!=19)
						cells[i][j+1].cellsAround--;
					if (i!=19)
					{
						if (j!=0)
							cells[i+1][j-1].cellsAround--;
						cells[i+1][j].cellsAround--;
						if (j!=19)
							cells[i+1][j+1].cellsAround--;
					}
				}

			cells[i][j].setNewStatus(newStatus);
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame ("Game of life");
		frame.setSize(210, 275);
		Container frm = frame.getContentPane();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setLayout(null);
		
		fillTheBoard(frm);

		JButton strt = new JButton("Start");
		strt.setBounds(5, 205, 200, 35);
		frm.add(strt);
		
		JLabel stps = new JLabel("Steps: 0     Population: "+Cell.population);
		stps.setBounds(15, 235, 200, 20);
		frm.add(stps);
		
		
		frame.setVisible(true);
		
		strt.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				strt.setEnabled(false);
				run (frm, stps);
			}
			
		});
	}
	public static void run(Container frm, JLabel stps)
	{
		Timer t = new Timer(150,null);
		t.addActionListener(new ActionListener(){
			int counter=0;
			int changed=0;
			@Override
			public void actionPerformed(ActionEvent e)
			{
				for (int i=0; i<20; i++)
				{
					for (int j=0; j<20; j++)
					{
						if (cells[i][j].status==1 && cells[i][j].cellsAround<2)
						{
							iAndJ[0][changed]=i;
							iAndJ[1][changed]=j;
							changed++;

						}
						if (cells[i][j].status==1 && cells[i][j].cellsAround>3)
						{
							iAndJ[0][changed]=i;
							iAndJ[1][changed]=j;
							changed++;
						}
						if (cells[i][j].status==0 && cells[i][j].cellsAround==3)
						{
							iAndJ[0][changed]=i;
							iAndJ[1][changed]=j;
							changed++;
						}
					}
				}
				int ii,jj,ss;
				for (int x=0; x<changed; x++)
				{
					ii=iAndJ[0][x];
					jj=iAndJ[1][x];
					ss=cells[ii][jj].status;
					cellUpdater (ii, jj, ss, (ss-1)*(ss-1));
				}
				changed=0;
				iAndJZeroer();
				counter++;
				stps.setText("Steps: " + counter + "     Population: "+Cell.population);
				frm.setVisible(true);
			}
			
		});
		t.start();
	}
	public static void iAndJZeroer()
	{
		for (int i=0; i<400; i++)
		{
			iAndJ[0][i]=-1;
			iAndJ[1][i]=-1;
		}
	}

}