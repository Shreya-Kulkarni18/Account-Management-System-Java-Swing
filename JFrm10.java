import java.awt.*;
import java.awt.event.*;

import javax.security.auth.login.AccountNotFoundException;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.*;
import java.io.*;
import java.util.LinkedList;
import mypkg.Util;

class Account implements Serializable {
    int ano;
    String anm;
    int abal;

    Account() {
        ano = 0;
        anm = "";
        abal = 0;
    }

    Account(int a, String b, int c) {
        ano = a;
        anm = b;
        abal = c;
    }

    public String toString() {
        String s = "Account Data:\n" + "Acc No:" + ano + "\nName" + anm + "Balance" + abal;
        return s;
    }

    void display() {
        Util.display(toString());
    }
}

class AAdd extends JDialog implements FocusListener, ActionListener {
    int no, bal, i, n;
    String nm;
    Account obj;
    LinkedList<Account> ls;
    JLabel l1, l2, l3;
    JTextField t1, t2, t3;
    JButton b1, b2;

    AAdd(JFrame frm, String title, boolean state, LinkedList<Account> ls) {
        super(frm, title, state);
        this.ls = ls;
        l1 = new JLabel("A/C No.");
        l2 = new JLabel("Name");
        l3 = new JLabel("Balance");
        t1 = new JTextField(10);
        t2 = new JTextField(20);
        t3 = new JTextField(10);

        b1 = new JButton("Add");
        b2 = new JButton("Back");

        t1.addFocusListener(this);
        t2.addFocusListener(this);
        t3.addFocusListener(this);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setLayout(new GridLayout(4, 2, 5, 5));

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(b1);
        add(b2);
        setSize(300, 400);
        setVisible(true);

    }

    public void focusGained(FocusEvent e) {
    }

    public void focusLost(FocusEvent e) {
        try {
            no = Integer.parseInt(t1.getText());
            n = ls.size();
            i = 0;
            while (i < n) {
                obj = ls.get(i);
                if (obj.ano == no)
                    break;
                else
                    i++;
            }
            if (i == n)
                obj = null;
            else {
                t1.requestFocus();
                return;
            }
        } catch (Exception e1) {
        }
    }

    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        if (b == b1)
            ;
        {
            try {
                no = Integer.parseInt(t1.getText());
                nm = t2.getText();
                bal = Integer.parseInt(t3.getText());
                obj = new Account(no, nm, bal);
                ls.add(obj);
            } catch (Exception e1) {
            }
        }
        setVisible(false);
    }
}


class AMod extends JDialog implements FocusListener, ActionListener {
    int no, bal, i, n;
    String nm;
    Account obj;
    LinkedList<Account> ls;
    JLabel l1, l2, l3;
    JTextField t1, t2, t3;
    JButton b1, b2;

    AMod(JFrame frm, String title, boolean state, LinkedList<Account> ls) {
        super(frm, title, state);
        this.ls = ls;
        l1 = new JLabel("A/C No.");
        l2 = new JLabel("Name");
        l3 = new JLabel("Balance");
        t1 = new JTextField(10);
        t2 = new JTextField(20);
        t3 = new JTextField(10);

        b1 = new JButton("Mod");
        b2 = new JButton("Back");

        t1.addFocusListener(this);
        t2.addFocusListener(this);
        t3.addFocusListener(this);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setLayout(new GridLayout(4, 2, 5, 5));

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(b1);
        add(b2);
        setSize(300, 400);
        setVisible(true);

    }

    public void focusGained(FocusEvent e) {
    }

    public void focusLost(FocusEvent e) {
        try {
            no = Integer.parseInt(t1.getText());
            n = ls.size();
            i = 0;
            while (i < n) {
                obj = ls.get(i);
                if (obj.ano == no)
                    break;
                else
                    i++;
            }
            if (i == n) // Record not found.
            {
                Util.display("Record not found.");
                t1.requestFocus();
                return;
            } else {
                t2.setText(obj.anm);
                t3.setText(""+obj.abal);
            }
        } catch (Exception e1) {
        }
    }

    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        if (b == b1) {
            try {
                no = Integer.parseInt(t1.getText());
                nm = t2.getText();
                bal = Integer.parseInt(t3.getText());

                obj.anm = nm;
                obj.abal = bal;
            } catch (Exception e1) {
            }
        }
        setVisible(false);
    }
}

class ADel extends JDialog implements FocusListener, ActionListener {
    int no, bal, i, n;
    String nm;
    Account obj;
    LinkedList<Account> ls;
    JLabel l1, l2, l3;
    JTextField t1, t2, t3;
    JButton b1, b2;

    ADel(JFrame frm, String title, boolean state, LinkedList<Account> ls) {
        super(frm, title, state);
        this.ls = ls;
        l1 = new JLabel("A/C No.");
        l2 = new JLabel("Name");
        l3 = new JLabel("Balance");
        t1 = new JTextField(10);
        t2 = new JTextField(20);
        t3 = new JTextField(10);

        b1 = new JButton("Delete");
        b2 = new JButton("Back");

        t1.addFocusListener(this);
        t2.addFocusListener(this);
        t3.addFocusListener(this);

        t2.setEditable(false);
        t3.setEditable(false);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setLayout(new GridLayout(4, 2, 5, 5));
        
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(b1);
        add(b2);
        setSize(300, 400);
        setVisible(true);

    }

    public void focusGained(FocusEvent e) 
    {
    }
    
    public void focusLost(FocusEvent e) 
    {
        try {
            no = Integer.parseInt(t1.getText());
            n = ls.size();
            i = 0;
            while (i < n) {
                obj = ls.get(i);
                if (obj.ano == no)
                    break;
                else
                    i++;
            }
            if (i == n) // Record not found.
            {
                Util.display("Record not found.");
                t1.requestFocus();
                return;
            } else {
                t2.setText(obj.anm);
                t3.setText(""+obj.abal);
            }
        } catch (Exception e1) {
        }
    }

    public void actionPerformed(ActionEvent e) 
    {
        JButton b = (JButton) e.getSource();
        if (b == b1) 
        {
            try 
            {
                ls.remove(obj);
            } catch (Exception e1) {
            }
        }
        setVisible(false);
    }
}
class ATable extends JDialog implements ActionListener
{
    LinkedList<Account>ls;
    JTable tb;
    DefaultTableModel dtm;
    JButton b1,b2;
    JPanel p1;
    JScrollPane jsp;
    Account obj;
    int i,n;
    ATable(JFrame frm,String title,boolean state,LinkedList<Account>ls)
    {
        super(frm,title,state);
        this.ls=ls;
        i=0;
        n=ls.size();
        dtm=new DefaultTableModel(new Object
        [][]{}, new String[] {"A/c No","Name","Balance"});
        tb=new JTable(dtm);
        while(i<n)
        {
            obj=ls.get(i);
            dtm.insertRow(i, new String[]{""+obj.ano,obj.anm,""+obj.abal});
            i++;
        }
        jsp=new JScrollPane(tb);
        add(jsp);
        b1=new JButton("Print");
        b2=new JButton("Back");
        b1.addActionListener(this);
        b2.addActionListener(this);
        p1=new JPanel();
        p1.add(b1);
        p1.add(b2);
        add(p1,BorderLayout.SOUTH);
        setSize(400, 300);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        JButton b=(JButton)e.getSource();
        if(b==b1)
        {
            try 
            {
                tb.print();
            } catch (Exception e3) {
                // TODO: handle exception
            }
        }
        setVisible(false);
    }
}


public class JFrm10 extends JFrame 
{
    JTree tr;
    JLabel l1;
    LinkedList<Account>ls;
    AAdd ad;
    AMod md;
    ADel dl;
    ATable at;
    DefaultMutableTreeNode top = new DefaultMutableTreeNode("Options");
    DefaultMutableTreeNode o = new DefaultMutableTreeNode("Account ");
    DefaultMutableTreeNode o1 = new DefaultMutableTreeNode("Add");
    DefaultMutableTreeNode o2 = new DefaultMutableTreeNode("Mod");
    DefaultMutableTreeNode o3 = new DefaultMutableTreeNode("Del");
    DefaultMutableTreeNode p = new DefaultMutableTreeNode("Records");
    DefaultMutableTreeNode p1 = new DefaultMutableTreeNode("Display");

    JFrm10() {
        super("Tree");
        ls=new LinkedList<Account>();
        l1 = new JLabel("Choice");

        top.add(o);

        o.add(o1);
        o.add(o2);
        o.add(o3);

        top.add(p);

        p.add(p1);
        tr = new JTree(top);
        JScrollPane jsp = new JScrollPane(tr);
        add(jsp);
        add(l1, BorderLayout.SOUTH);
        tr.addTreeSelectionListener(new TreeSelectionListener() 
        {
            public void valueChanged(TreeSelectionEvent e) 
            {
                DefaultMutableTreeNode a = (DefaultMutableTreeNode) tr.getLastSelectedPathComponent();
                if (a != null) {
                    if (a.isLeaf()) 
                    {
                        if (a == o1)
                            ad=new AAdd(null,"New Account",true,ls);

                        if (a == o2)
                             md=new AMod(null,"Modify Account",true,ls);

                        if (a == o3)
                             dl=new ADel(null,"Delete Account",true,ls);
                        if (a == p1)
                             at=new ATable(null,"Display",true,ls);
                    }
                }
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        JFrm10 a = new JFrm10();
    }
}