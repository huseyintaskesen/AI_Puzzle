package ai_puzzle;

import static ai_puzzle.AI_PUZZLE.a;
import static ai_puzzle.AI_PUZZLE.accross;
import static ai_puzzle.AI_PUZZLE.blockCheck;
import static ai_puzzle.AI_PUZZLE.boxNumbers;
import static ai_puzzle.AI_PUZZLE.d;
import static ai_puzzle.AI_PUZZLE.down;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.lang.Math; 
import static java.sql.JDBCType.NULL;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yerel Kullanıcı
 */
public class PUZZLE extends javax.swing.JFrame implements Runnable { 
    int hour, second, minute;
    int day, month, year;
    String timeStr, yearStr;
    
    static int milliseconds = 0;
    static int seconds = 0;
    static int minutes = 0;
    static int hours = 0;
    
    static boolean state = false;
    static boolean start = false;
    static boolean revealed = false;
    
    
    /**
     * Creates new form PUZZLE
     */
    public PUZZLE() {
        Thread t = new Thread(this);
        t.start();
        
        initComponents();
        
        box0.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3), boxNumbers[0], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3), boxNumbers[1], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3), boxNumbers[2], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3), boxNumbers[3], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3), boxNumbers[4], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3), boxNumbers[5], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3), boxNumbers[6], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3), boxNumbers[7], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3), boxNumbers[8], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3), boxNumbers[9], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3), boxNumbers[10], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3), boxNumbers[11], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3), boxNumbers[12], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3), boxNumbers[13], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box14.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3), boxNumbers[14], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box15.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3), boxNumbers[15], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box16.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3), boxNumbers[16], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box17.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3), boxNumbers[17], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box18.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3), boxNumbers[18], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box19.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3), boxNumbers[19], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box20.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3), boxNumbers[20], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box21.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3), boxNumbers[21], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box22.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3), boxNumbers[22], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box23.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3), boxNumbers[23], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box24.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3), boxNumbers[24], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        
        
        if(blockCheck[0] == false)
            box0.setBackground(Color.black);
        if(blockCheck[1] == false)
            box1.setBackground(Color.black);
        if(blockCheck[2] == false)
            box2.setBackground(Color.black);
        if(blockCheck[3] == false)
            box3.setBackground(Color.black);
        if(blockCheck[4] == false)
            box4.setBackground(Color.black);
        if(blockCheck[5] == false)
            box5.setBackground(Color.black);
        if(blockCheck[6] == false)
            box6.setBackground(Color.black);
        if(blockCheck[7] == false)
            box7.setBackground(Color.black);
        if(blockCheck[8] == false)
            box8.setBackground(Color.black);
        if(blockCheck[9] == false)
            box9.setBackground(Color.black);
        if(blockCheck[10] == false)
            box10.setBackground(Color.black);
        if(blockCheck[11] == false)
            box11.setBackground(Color.black);
        if(blockCheck[12] == false)
            box12.setBackground(Color.black);
        if(blockCheck[13] == false)
            box13.setBackground(Color.black);
        if(blockCheck[14] == false)
            box14.setBackground(Color.black);
        if(blockCheck[15] == false)
            box15.setBackground(Color.black);
        if(blockCheck[16] == false)
            box16.setBackground(Color.black);
        if(blockCheck[17] == false)
            box17.setBackground(Color.black);
        if(blockCheck[18] == false)
            box18.setBackground(Color.black);
        if(blockCheck[19] == false)
            box19.setBackground(Color.black);
        if(blockCheck[20] == false)
            box20.setBackground(Color.black);
        if(blockCheck[21] == false)
            box21.setBackground(Color.black);
        if(blockCheck[22] == false)
            box22.setBackground(Color.black);
        if(blockCheck[23] == false)
            box23.setBackground(Color.black);
        if(blockCheck[24] == false)
            box24.setBackground(Color.black);
           
        currentDate();
        setBounds(280, 50, 1569, 1232);
        setResizable(true);
        
        accross0.setText(accross[0]);
        accross1.setText(accross[1]);
        accross2.setText(accross[2]);
        accross3.setText(accross[3]);
        accross4.setText(accross[4]);
        
        down0.setText(down[0]);
        down1.setText(down[1]);
        down2.setText(down[2]);
        down3.setText(down[3]);
        down4.setText(down[4]);
        
        a0.setText(a[0]);
        a1.setText(a[1]);
        a2.setText(a[2]);
        a3.setText(a[3]);
        a4.setText(a[4]);
        
        d0.setText(d[0]);
        d1.setText(d[1]);
        d2.setText(d[2]);
        d3.setText(d[3]);
        d4.setText(d[4]);   
    
    }
   
    public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
    /*
    public void getTime(){
        
    }
    */
    public void currentDate(){
        Calendar cal = Calendar.getInstance();
        
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date dat = cal.getTime();
        String yearStr = df.format(dat);
        
        date_txt.setText(yearStr);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        date_time_panel = new javax.swing.JPanel();
        date_txt = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        timer_txt = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        QUESTIONS_PANEL = new javax.swing.JPanel();
        ACCROSS_PANEL = new javax.swing.JPanel();
        a0 = new javax.swing.JLabel();
        accross0 = new javax.swing.JLabel();
        a1 = new javax.swing.JLabel();
        accross1 = new javax.swing.JLabel();
        a2 = new javax.swing.JLabel();
        accross2 = new javax.swing.JLabel();
        a3 = new javax.swing.JLabel();
        accross3 = new javax.swing.JLabel();
        a4 = new javax.swing.JLabel();
        accross4 = new javax.swing.JLabel();
        DOWN_PANEL = new javax.swing.JPanel();
        d0 = new javax.swing.JLabel();
        d4 = new javax.swing.JLabel();
        down4 = new javax.swing.JLabel();
        down0 = new javax.swing.JLabel();
        d2 = new javax.swing.JLabel();
        d3 = new javax.swing.JLabel();
        down1 = new javax.swing.JLabel();
        down3 = new javax.swing.JLabel();
        down2 = new javax.swing.JLabel();
        d1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        PUZZLE_PANEL = new javax.swing.JPanel();
        box2 = new javax.swing.JLabel();
        box1 = new javax.swing.JLabel();
        box4 = new javax.swing.JLabel();
        box3 = new javax.swing.JLabel();
        box0 = new javax.swing.JLabel();
        box5 = new javax.swing.JLabel();
        box6 = new javax.swing.JLabel();
        box7 = new javax.swing.JLabel();
        box8 = new javax.swing.JLabel();
        box9 = new javax.swing.JLabel();
        box10 = new javax.swing.JLabel();
        box11 = new javax.swing.JLabel();
        box12 = new javax.swing.JLabel();
        box13 = new javax.swing.JLabel();
        box14 = new javax.swing.JLabel();
        box15 = new javax.swing.JLabel();
        box16 = new javax.swing.JLabel();
        box17 = new javax.swing.JLabel();
        box18 = new javax.swing.JLabel();
        box19 = new javax.swing.JLabel();
        box20 = new javax.swing.JLabel();
        box21 = new javax.swing.JLabel();
        box22 = new javax.swing.JLabel();
        box23 = new javax.swing.JLabel();
        box24 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        timekeeper = new javax.swing.JPanel();
        timekeeper_txt = new javax.swing.JLabel();
        stop_time = new javax.swing.JButton();
        start_time = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        reveal = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 153));

        jDesktopPane1.setBackground(new java.awt.Color(0, 51, 153));

        date_time_panel.setBackground(new java.awt.Color(102, 102, 102));
        date_time_panel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Date", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 24), new java.awt.Color(204, 204, 204))); // NOI18N

        date_txt.setBackground(new java.awt.Color(51, 51, 51));
        date_txt.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        date_txt.setForeground(new java.awt.Color(204, 204, 204));
        date_txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        date_txt.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));
        date_txt.setOpaque(true);

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Time", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(204, 204, 204))); // NOI18N

        timer_txt.setBackground(new java.awt.Color(51, 51, 51));
        timer_txt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        timer_txt.setForeground(new java.awt.Color(204, 204, 204));
        timer_txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timer_txt.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));
        timer_txt.setOpaque(true);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(timer_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(timer_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout date_time_panelLayout = new javax.swing.GroupLayout(date_time_panel);
        date_time_panel.setLayout(date_time_panelLayout);
        date_time_panelLayout.setHorizontalGroup(
            date_time_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(date_time_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(date_txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(date_time_panelLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        date_time_panelLayout.setVerticalGroup(
            date_time_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(date_time_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(date_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel21.setBackground(new java.awt.Color(51, 51, 51));
        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(204, 204, 204));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Cruciverbalists");
        jLabel21.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.darkGray, java.awt.Color.darkGray, java.awt.Color.darkGray), javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.darkGray, java.awt.Color.darkGray)));
        jLabel21.setOpaque(true);

        QUESTIONS_PANEL.setBackground(new java.awt.Color(102, 102, 102));
        QUESTIONS_PANEL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        ACCROSS_PANEL.setBackground(new java.awt.Color(51, 51, 51));
        ACCROSS_PANEL.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3), "ACCROSS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(204, 204, 204))); // NOI18N

        a0.setBackground(new java.awt.Color(204, 204, 204));
        a0.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        a0.setForeground(new java.awt.Color(204, 204, 204));
        a0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        accross0.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        accross0.setForeground(new java.awt.Color(204, 204, 204));
        accross0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        a1.setBackground(new java.awt.Color(204, 204, 204));
        a1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        a1.setForeground(new java.awt.Color(204, 204, 204));
        a1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        accross1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        accross1.setForeground(new java.awt.Color(204, 204, 204));
        accross1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        a2.setBackground(new java.awt.Color(204, 204, 204));
        a2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        a2.setForeground(new java.awt.Color(204, 204, 204));
        a2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        accross2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        accross2.setForeground(new java.awt.Color(204, 204, 204));
        accross2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        a3.setBackground(new java.awt.Color(204, 204, 204));
        a3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        a3.setForeground(new java.awt.Color(204, 204, 204));
        a3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        accross3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        accross3.setForeground(new java.awt.Color(204, 204, 204));
        accross3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        a4.setBackground(new java.awt.Color(204, 204, 204));
        a4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        a4.setForeground(new java.awt.Color(204, 204, 204));
        a4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        accross4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        accross4.setForeground(new java.awt.Color(204, 204, 204));
        accross4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout ACCROSS_PANELLayout = new javax.swing.GroupLayout(ACCROSS_PANEL);
        ACCROSS_PANEL.setLayout(ACCROSS_PANELLayout);
        ACCROSS_PANELLayout.setHorizontalGroup(
            ACCROSS_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ACCROSS_PANELLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ACCROSS_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(a4, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                    .addComponent(a3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(a2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(a0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(a1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ACCROSS_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(accross0, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
                    .addComponent(accross1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(accross2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(accross3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(accross4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        ACCROSS_PANELLayout.setVerticalGroup(
            ACCROSS_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ACCROSS_PANELLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(ACCROSS_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(accross0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(a0, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ACCROSS_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accross1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ACCROSS_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(accross2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(a2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ACCROSS_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accross3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ACCROSS_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(accross4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(a4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        DOWN_PANEL.setBackground(new java.awt.Color(51, 51, 51));
        DOWN_PANEL.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3), "DOWN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(204, 204, 204))); // NOI18N

        d0.setBackground(new java.awt.Color(204, 204, 204));
        d0.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        d0.setForeground(new java.awt.Color(204, 204, 204));
        d0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        d4.setBackground(new java.awt.Color(204, 204, 204));
        d4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        d4.setForeground(new java.awt.Color(204, 204, 204));
        d4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        down4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        down4.setForeground(new java.awt.Color(204, 204, 204));
        down4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        down0.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        down0.setForeground(new java.awt.Color(204, 204, 204));
        down0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        d2.setBackground(new java.awt.Color(204, 204, 204));
        d2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        d2.setForeground(new java.awt.Color(204, 204, 204));
        d2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        d3.setBackground(new java.awt.Color(204, 204, 204));
        d3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        d3.setForeground(new java.awt.Color(204, 204, 204));
        d3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        down1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        down1.setForeground(new java.awt.Color(204, 204, 204));
        down1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        down3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        down3.setForeground(new java.awt.Color(204, 204, 204));
        down3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        down2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        down2.setForeground(new java.awt.Color(204, 204, 204));
        down2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        d1.setBackground(new java.awt.Color(204, 204, 204));
        d1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        d1.setForeground(new java.awt.Color(204, 204, 204));
        d1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout DOWN_PANELLayout = new javax.swing.GroupLayout(DOWN_PANEL);
        DOWN_PANEL.setLayout(DOWN_PANELLayout);
        DOWN_PANELLayout.setHorizontalGroup(
            DOWN_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DOWN_PANELLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DOWN_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(d4, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                    .addComponent(d3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(d2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(d0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(d1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DOWN_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(down0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(down1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(down2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(down3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(down4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        DOWN_PANELLayout.setVerticalGroup(
            DOWN_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DOWN_PANELLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(DOWN_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(down0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(d0, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DOWN_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(down1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DOWN_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(down2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(d2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DOWN_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(down3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DOWN_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(down4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(d4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout QUESTIONS_PANELLayout = new javax.swing.GroupLayout(QUESTIONS_PANEL);
        QUESTIONS_PANEL.setLayout(QUESTIONS_PANELLayout);
        QUESTIONS_PANELLayout.setHorizontalGroup(
            QUESTIONS_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QUESTIONS_PANELLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(QUESTIONS_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ACCROSS_PANEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DOWN_PANEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        QUESTIONS_PANELLayout.setVerticalGroup(
            QUESTIONS_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QUESTIONS_PANELLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(ACCROSS_PANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(DOWN_PANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Project Members", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 24), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));

        jLabel24.setBackground(new java.awt.Color(51, 51, 51));
        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(204, 204, 204));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Deniz Evrensel");
        jLabel24.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));
        jLabel24.setOpaque(true);

        jLabel22.setBackground(new java.awt.Color(51, 51, 51));
        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(204, 204, 204));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Asaf Kağan Bezgin");
        jLabel22.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));
        jLabel22.setOpaque(true);

        jLabel30.setBackground(new java.awt.Color(51, 51, 51));
        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(204, 204, 204));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("21402271");
        jLabel30.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));
        jLabel30.setOpaque(true);

        jLabel26.setBackground(new java.awt.Color(51, 51, 51));
        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(204, 204, 204));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Servan Tanaman");
        jLabel26.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));
        jLabel26.setOpaque(true);

        jLabel28.setBackground(new java.awt.Color(51, 51, 51));
        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(204, 204, 204));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("21402006");
        jLabel28.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));
        jLabel28.setOpaque(true);

        jLabel31.setBackground(new java.awt.Color(51, 51, 51));
        jLabel31.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(204, 204, 204));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("21201977");
        jLabel31.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));
        jLabel31.setOpaque(true);

        jLabel23.setBackground(new java.awt.Color(51, 51, 51));
        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(204, 204, 204));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Amr El Shimy");
        jLabel23.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));
        jLabel23.setOpaque(true);

        jLabel25.setBackground(new java.awt.Color(51, 51, 51));
        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(204, 204, 204));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Hüseyin Taşkesen");
        jLabel25.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));
        jLabel25.setOpaque(true);

        jLabel27.setBackground(new java.awt.Color(51, 51, 51));
        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(204, 204, 204));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("21600569");
        jLabel27.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));
        jLabel27.setOpaque(true);

        jLabel29.setBackground(new java.awt.Color(51, 51, 51));
        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(204, 204, 204));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("21401841");
        jLabel29.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));
        jLabel29.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel22, jLabel23, jLabel24, jLabel25, jLabel26, jLabel27, jLabel28, jLabel29, jLabel30, jLabel31});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel22, jLabel23, jLabel24, jLabel25, jLabel26, jLabel27, jLabel28, jLabel29, jLabel30, jLabel31});

        PUZZLE_PANEL.setBackground(new java.awt.Color(102, 102, 102));
        PUZZLE_PANEL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        PUZZLE_PANEL.setForeground(new java.awt.Color(102, 102, 102));

        box2.setBackground(new java.awt.Color(204, 204, 204));
        box2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box2.setOpaque(true);

        box1.setBackground(new java.awt.Color(204, 204, 204));
        box1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box1.setOpaque(true);

        box4.setBackground(new java.awt.Color(204, 204, 204));
        box4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box4.setOpaque(true);

        box3.setBackground(new java.awt.Color(204, 204, 204));
        box3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box3.setOpaque(true);

        box0.setBackground(new java.awt.Color(204, 204, 204));
        box0.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box0.setOpaque(true);

        box5.setBackground(new java.awt.Color(204, 204, 204));
        box5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box5.setOpaque(true);

        box6.setBackground(new java.awt.Color(204, 204, 204));
        box6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box6.setOpaque(true);

        box7.setBackground(new java.awt.Color(204, 204, 204));
        box7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box7.setOpaque(true);

        box8.setBackground(new java.awt.Color(204, 204, 204));
        box8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box8.setOpaque(true);

        box9.setBackground(new java.awt.Color(204, 204, 204));
        box9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box9.setOpaque(true);

        box10.setBackground(new java.awt.Color(204, 204, 204));
        box10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box10.setOpaque(true);

        box11.setBackground(new java.awt.Color(204, 204, 204));
        box11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box11.setOpaque(true);

        box12.setBackground(new java.awt.Color(204, 204, 204));
        box12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box12.setOpaque(true);

        box13.setBackground(new java.awt.Color(204, 204, 204));
        box13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box13.setOpaque(true);

        box14.setBackground(new java.awt.Color(204, 204, 204));
        box14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box14.setOpaque(true);

        box15.setBackground(new java.awt.Color(204, 204, 204));
        box15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box15.setOpaque(true);

        box16.setBackground(new java.awt.Color(204, 204, 204));
        box16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box16.setOpaque(true);

        box17.setBackground(new java.awt.Color(204, 204, 204));
        box17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box17.setOpaque(true);

        box18.setBackground(new java.awt.Color(204, 204, 204));
        box18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box18.setOpaque(true);

        box19.setBackground(new java.awt.Color(204, 204, 204));
        box19.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box19.setOpaque(true);

        box20.setBackground(new java.awt.Color(204, 204, 204));
        box20.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box20.setOpaque(true);

        box21.setBackground(new java.awt.Color(204, 204, 204));
        box21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box21.setOpaque(true);

        box22.setBackground(new java.awt.Color(204, 204, 204));
        box22.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box22.setOpaque(true);

        box23.setBackground(new java.awt.Color(204, 204, 204));
        box23.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box23.setOpaque(true);

        box24.setBackground(new java.awt.Color(204, 204, 204));
        box24.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box24.setOpaque(true);

        javax.swing.GroupLayout PUZZLE_PANELLayout = new javax.swing.GroupLayout(PUZZLE_PANEL);
        PUZZLE_PANEL.setLayout(PUZZLE_PANELLayout);
        PUZZLE_PANELLayout.setHorizontalGroup(
            PUZZLE_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PUZZLE_PANELLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(PUZZLE_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PUZZLE_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PUZZLE_PANELLayout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(box0, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(box1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(box2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(box3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(box4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PUZZLE_PANELLayout.createSequentialGroup()
                            .addComponent(box5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(box6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(box7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(box8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(box9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PUZZLE_PANELLayout.createSequentialGroup()
                            .addComponent(box10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(box11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(box12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(box13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(box14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PUZZLE_PANELLayout.createSequentialGroup()
                        .addComponent(box15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(box16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(box17, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(box18, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(box19, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PUZZLE_PANELLayout.createSequentialGroup()
                        .addComponent(box20, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(box21, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(box22, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(box23, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(box24, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PUZZLE_PANELLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {box0, box1, box10, box11, box12, box13, box14, box15, box16, box17, box18, box19, box2, box20, box21, box22, box23, box24, box3, box4, box5, box6, box7, box8, box9});

        PUZZLE_PANELLayout.setVerticalGroup(
            PUZZLE_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PUZZLE_PANELLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(PUZZLE_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(box2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box0, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PUZZLE_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(box7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PUZZLE_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(box12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PUZZLE_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(box17, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box19, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box18, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PUZZLE_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(box22, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box21, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box24, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box23, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box20, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PUZZLE_PANELLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {box0, box1, box10, box11, box12, box13, box14, box15, box16, box17, box18, box19, box2, box20, box21, box22, box23, box24, box3, box4, box5, box6, box7, box8, box9});

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Course Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 24), new java.awt.Color(204, 204, 204))); // NOI18N

        jTextArea1.setBackground(new java.awt.Color(102, 102, 102));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(204, 204, 204));
        jTextArea1.setRows(3);
        jTextArea1.setText("                        CS 461-1\n             Artificial Intelligence\n       Instructor: VAROL AKMAN");
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1)
                .addGap(15, 15, 15))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Time Keeper", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel2.setOpaque(false);

        timekeeper.setBackground(new java.awt.Color(0, 102, 102));
        timekeeper.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Timekeeper", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12))); // NOI18N

        timekeeper_txt.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        timekeeper_txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timekeeper_txt.setText("00:00");

        javax.swing.GroupLayout timekeeperLayout = new javax.swing.GroupLayout(timekeeper);
        timekeeper.setLayout(timekeeperLayout);
        timekeeperLayout.setHorizontalGroup(
            timekeeperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(timekeeper_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
        );
        timekeeperLayout.setVerticalGroup(
            timekeeperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(timekeeper_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        stop_time.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai_puzzle/Button-Pause-icon.png")));
        stop_time.setContentAreaFilled(false);
        stop_time.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stop_timeActionPerformed(evt);
            }
        });

        start_time.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai_puzzle/Button-Play-icon.png")));
        start_time.setContentAreaFilled(false);
        start_time.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                start_timeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(stop_time, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(start_time, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timekeeper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {start_time, stop_time});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(start_time, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stop_time, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                    .addComponent(timekeeper, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {start_time, stop_time});

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reveal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel5.setOpaque(false);

        reveal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai_puzzle/Search-Results-icon.png")));
        reveal.setContentAreaFilled(false);
        reveal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                revealActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(reveal)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(reveal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jButton1.setText("Get Random Puzzle");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Get Other Clues");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(date_time_panel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel21, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(QUESTIONS_PANEL, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(PUZZLE_PANEL, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(date_time_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(110, 110, 110)))
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(PUZZLE_PANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(129, 129, 129)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(115, 115, 115))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(127, 127, 127)
                                .addComponent(QUESTIONS_PANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(date_time_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PUZZLE_PANEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(QUESTIONS_PANEL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(158, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 125, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void start_timeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_start_timeActionPerformed
        if(revealed != true){
            state = true;
 
            Thread t;
            t = new Thread()
            {
                public void run()
                {

                    for(;;)
                    {
                        if(state == true)
                        {
                            try{
                                sleep(1);
                                if(milliseconds > 499)
                                {
                                    milliseconds = 0;
                                    seconds++;
                                }
                                if(seconds > 59)
                                {
                                    milliseconds = 0;
                                    seconds = 0;
                                    minutes++;
                                }                            

                                milliseconds++;
                                if(seconds < 10 )
                                    timekeeper_txt.setText("0" + minutes + " :" + " 0" + seconds);
                                else
                                    timekeeper_txt.setText("0" + minutes + " : " + seconds);
                            }catch(Exception e)
                            {
                                e.printStackTrace();
                            }
                        }
                        else
                        {
                            break;
                        }
                    }
                }
            };
            t.start(); 
        }           
    }//GEN-LAST:event_start_timeActionPerformed

    private void stop_timeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stop_timeActionPerformed
        state = false;
    }//GEN-LAST:event_stop_timeActionPerformed

    private void revealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_revealActionPerformed
        revealed = true;
        state = false;

        box0.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[0], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[1], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[2], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[3], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[4], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[5], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[6], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[7], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[8], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[9], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[10], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[11], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[12], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[13], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box14.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[14], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box15.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[15], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box16.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[16], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box17.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[17], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box18.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[18], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box19.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[19], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box20.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[20], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box21.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[21], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box22.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[22], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box23.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[23], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box24.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[24], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        
        
        if(blockCheck[0] == false)
            box0.setBackground(Color.black);
        if(blockCheck[1] == false)
            box1.setBackground(Color.black);
        if(blockCheck[2] == false)
            box2.setBackground(Color.black);
        if(blockCheck[3] == false)
            box3.setBackground(Color.black);
        if(blockCheck[4] == false)
            box4.setBackground(Color.black);
        if(blockCheck[5] == false)
            box5.setBackground(Color.black);
        if(blockCheck[6] == false)
            box6.setBackground(Color.black);
        if(blockCheck[7] == false)
            box7.setBackground(Color.black);
        if(blockCheck[8] == false)
            box8.setBackground(Color.black);
        if(blockCheck[9] == false)
            box9.setBackground(Color.black);
        if(blockCheck[10] == false)
            box10.setBackground(Color.black);
        if(blockCheck[11] == false)
            box11.setBackground(Color.black);
        if(blockCheck[12] == false)
            box12.setBackground(Color.black);
        if(blockCheck[13] == false)
            box13.setBackground(Color.black);
        if(blockCheck[14] == false)
            box14.setBackground(Color.black);
        if(blockCheck[15] == false)
            box15.setBackground(Color.black);
        if(blockCheck[16] == false)
            box16.setBackground(Color.black);
        if(blockCheck[17] == false)
            box17.setBackground(Color.black);
        if(blockCheck[18] == false)
            box18.setBackground(Color.black);
        if(blockCheck[19] == false)
            box19.setBackground(Color.black);
        if(blockCheck[20] == false)
            box20.setBackground(Color.black);
        if(blockCheck[21] == false)
            box21.setBackground(Color.black);
        if(blockCheck[22] == false)
            box22.setBackground(Color.black);
        if(blockCheck[23] == false)
            box23.setBackground(Color.black);
        if(blockCheck[24] == false)
            box24.setBackground(Color.black);
        
        accross0.setText(accross[0]);
        accross1.setText(accross[1]);
        accross2.setText(accross[2]);
        accross3.setText(accross[3]);
        accross4.setText(accross[4]);
        
        down0.setText(down[0]);
        down1.setText(down[1]);
        down2.setText(down[2]);
        down3.setText(down[3]);
        down4.setText(down[4]);
        
        a0.setText(a[0]);
        a1.setText(a[1]);
        a2.setText(a[2]);
        a3.setText(a[3]);
        a4.setText(a[4]);
        
        d0.setText(d[0]);
        d1.setText(d[1]);
        d2.setText(d[2]);
        d3.setText(d[3]);
        d4.setText(d[4]);
    }//GEN-LAST:event_revealActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setBoxesDefault();
        
        for(int u = 0; u < 25; u++)
            blockCheck[u] = true;
        
        try{
            String element = "div.ClueList-wrapper--3m-kd";
            
            File first = new File("D:\\Users\\amr-e\\Desktop\\AI_PUZZLE\\saved htmls\\4 February 2019 .html");
            File second = new File("D:\\Users\\amr-e\\Desktop\\AI_PUZZLE\\saved htmls\\5February 2019 .html");
            File third = new File("D:\\Users\\amr-e\\Desktop\\AI_PUZZLE\\saved htmls\\6February 2019 .html");
            File four = new File("D:\\Users\\amr-e\\Desktop\\AI_PUZZLE\\saved htmls\\24April.html");
            File five = new File("D:\\Users\\amr-e\\Desktop\\AI_PUZZLE\\saved htmls\\dec4.html");
            File six = new File("D:\\Users\\amr-e\\Desktop\\AI_PUZZLE\\saved htmls\\dec6.html");
            File seven = new File("D:\\Users\\amr-e\\Desktop\\AI_PUZZLE\\saved htmls\\dec9.html");
            File eight = new File("D:\\Users\\amr-e\\Desktop\\AI_PUZZLE\\saved htmls\\dec13.html");
            File nine = new File("D:\\Users\\amr-e\\Desktop\\AI_PUZZLE\\saved htmls\\dec14.html");
            File ten  = new File("D:\\Users\\amr-e\\Desktop\\AI_PUZZLE\\saved htmls\\dec17.html");
                    
                                            
            File input = first;
            
            
        // define the range 
        int max = 10; 
        int min = 1; 
        int range = max - min + 1; 
  
        // generate random numbers within 1 to 10 
         
            int rand = (int)(Math.random() * range) + min;             
            
            
            if(rand==0)
                input = first;
            else if(rand==1)
                input = second;
            else if(rand==2)
                input = third;
            else if(rand==3)
                input = four;
            else if(rand==4)
                input = five;
            else if(rand==5)
                input = six;
            else if(rand==6)
                input = seven;
            else if(rand==7)
                input = eight;
            else if(rand==8)
                input = nine;
            else if(rand==9)
                input = ten;
            
            //Document doc = Jsoup.connect(url).userAgent("Mozilla/17.0").get();
            
            
            Document doc = Jsoup.parse(input,"UTF-8");
            Elements temp = doc.select(element);
            
            //___________________________
            //___________________________
            
            int i = 0;
            
            for(Element myList:temp)
            {
                i++;
                if(i == 1)
                {
                    accross[0] = myList.getElementsByTag("li").first().text().substring(1, myList.getElementsByTag("li").first().text().length());
                    a[0] = myList.getElementsByTag("li").first().text().substring(0, 1);
                    
                    accross[1] = myList.getElementsByTag("li").next().first().text().substring(1,myList.getElementsByTag("li").next().first().text().length());
                    a[1] = myList.getElementsByTag("li").next().first().text().substring(0, 1);
                    
                    accross[2] = myList.getElementsByTag("li").next().next().first().text().substring(1, myList.getElementsByTag("li").next().next().first().text().length());
                    a[2] = myList.getElementsByTag("li").next().next().first().text().substring(0, 1);
                    
                    accross[3] = myList.getElementsByTag("li").next().next().next().first().text().substring(1, myList.getElementsByTag("li").next().next().next().first().text().length());
                    a[3] = myList.getElementsByTag("li").next().next().next().first().text().substring(0, 1);
                    
                    accross[4] = myList.getElementsByTag("li").next().next().next().next().first().text().substring(1, myList.getElementsByTag("li").next().next().next().next().first().text().length());                 
                    a[4] = myList.getElementsByTag("li").next().next().next().next().first().text().substring(0, 1);
                    
                }else
                {
                    down[0] = myList.getElementsByTag("li").first().text().substring(1,myList.getElementsByTag("li").first().text().length());
                    d[0] = myList.getElementsByTag("li").first().text().substring(0, 1);
                    
                    down[1] = myList.getElementsByTag("li").next().first().text().substring(1,myList.getElementsByTag("li").next().first().text().length());
                    d[1] = myList.getElementsByTag("li").next().first().text().substring(0, 1);
                    
                    down[2] = myList.getElementsByTag("li").next().next().first().text().substring(1,myList.getElementsByTag("li").next().next().first().text().length());
                    d[2] = myList.getElementsByTag("li").next().next().first().text().substring(0, 1);
                    
                    down[3] = myList.getElementsByTag("li").next().next().next().first().text().substring(1,myList.getElementsByTag("li").next().next().next().first().text().length());
                    d[3] = myList.getElementsByTag("li").next().next().next().first().text().substring(0, 1);
                    
                    down[4] = myList.getElementsByTag("li").next().next().next().next().first().text().substring(1,myList.getElementsByTag("li").next().next().next().next().first().text().length());
                    d[4] = myList.getElementsByTag("li").next().next().next().next().first().text().substring(0, 1);
                
                }                           
            }   
            
            //___________________________
            
            String element1 = "div.Board-boardContent--1AzTH svg g g";
            
            //Document doc1 = Jsoup.connect(url).userAgent("Mozilla/17.0").get();
            Document doc1 = Jsoup.parse(input,"UTF-8");
            
            Elements temp1 = doc1.select(element1);
            
            int k = 0;

            for(Element boxList : temp1)
            {
                
                boxNumbers[k++] = boxList.getElementsByTag("g").text();
          
                //System.out.println(boxList.getAllElements().text());
            } 
            
            /*
            for(int t = 0; t < 25; t++)
            {
                System.out.println(boxNumbers[t]);
            }
            */
            
            String element2 = "div.Board-boardContent--1AzTH svg g g";
            
            Document doc2 = Jsoup.parse(input,"UTF-8");
            //Document doc2 = Jsoup.connect(url).userAgent("Mozilla/17.0").get();
            
            Elements temp2 = doc2.select(element2);
            
            int j = 0;

            for(Element boxList2 : temp2)
            {   
                //System.out.println(j++ + " " + boxList2.getAllElements());
                
                if(boxList2.getAllElements().hasClass("Cell-block--1oNaD"))
                    blockCheck[j++] = false;
                else
                    j++;

            }           
        }catch(IOException e){
            e.printStackTrace();
        }         
        
        revealed = true;
        state = false;

        box0.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[0], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[1], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[2], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[3], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[4], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[5], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[6], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[7], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[8], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[9], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[10], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[11], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[12], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[13], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box14.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[14], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box15.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[15], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box16.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[16], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box17.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[17], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box18.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[18], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box19.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[19], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box20.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[20], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box21.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[21], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box22.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[22], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box23.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[23], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        box24.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3), boxNumbers[24], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 0)));
        
        
        if(blockCheck[0] == false)
            box0.setBackground(Color.black);
        if(blockCheck[1] == false)
            box1.setBackground(Color.black);
        if(blockCheck[2] == false)
            box2.setBackground(Color.black);
        if(blockCheck[3] == false)
            box3.setBackground(Color.black);
        if(blockCheck[4] == false)
            box4.setBackground(Color.black);
        if(blockCheck[5] == false)
            box5.setBackground(Color.black);
        if(blockCheck[6] == false)
            box6.setBackground(Color.black);
        if(blockCheck[7] == false)
            box7.setBackground(Color.black);
        if(blockCheck[8] == false)
            box8.setBackground(Color.black);
        if(blockCheck[9] == false)
            box9.setBackground(Color.black);
        if(blockCheck[10] == false)
            box10.setBackground(Color.black);
        if(blockCheck[11] == false)
            box11.setBackground(Color.black);
        if(blockCheck[12] == false)
            box12.setBackground(Color.black);
        if(blockCheck[13] == false)
            box13.setBackground(Color.black);
        if(blockCheck[14] == false)
            box14.setBackground(Color.black);
        if(blockCheck[15] == false)
            box15.setBackground(Color.black);
        if(blockCheck[16] == false)
            box16.setBackground(Color.black);
        if(blockCheck[17] == false)
            box17.setBackground(Color.black);
        if(blockCheck[18] == false)
            box18.setBackground(Color.black);
        if(blockCheck[19] == false)
            box19.setBackground(Color.black);
        if(blockCheck[20] == false)
            box20.setBackground(Color.black);
        if(blockCheck[21] == false)
            box21.setBackground(Color.black);
        if(blockCheck[22] == false)
            box22.setBackground(Color.black);
        if(blockCheck[23] == false)
            box23.setBackground(Color.black);
        if(blockCheck[24] == false)
            box24.setBackground(Color.black);
        
    accross0.setText(accross[0]);
        accross1.setText(accross[1]);
        accross2.setText(accross[2]);
        accross3.setText(accross[3]);
        accross4.setText(accross[4]);
        
        down0.setText(down[0]);
        down1.setText(down[1]);
        down2.setText(down[2]);
        down3.setText(down[3]);
        down4.setText(down[4]);
        
        a0.setText(a[0]);
        a1.setText(a[1]);
        a2.setText(a[2]);
        a3.setText(a[3]);
        a4.setText(a[4]);
        
        d0.setText(d[0]);
        d1.setText(d[1]);
        d2.setText(d[2]);
        d3.setText(d[3]);
        d4.setText(d[4]);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Scrapper newScrape = new Scrapper();
        
        try {
            newScrape.extractAnswers();
        } catch (InterruptedException ex) {
            Logger.getLogger(PUZZLE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AWTException ex) {
            Logger.getLogger(PUZZLE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PUZZLE.class.getName()).log(Level.SEVERE, null, ex);
        }
        String newAcrossHints [] = newScrape.ourDictionarySearch(newScrape.answersAcross);
        String newDownHints [] = newScrape.ourDictionarySearch(newScrape.answersDown);
        try{
            String element = "div.ClueList-wrapper--3m-kd";
         
            String url = "https://www.nytimes.com/crosswords/game/mini";
            
            Document doc = Jsoup.connect(url).userAgent("Mozilla/17.0").get();
            
            Elements temp = doc.select(element);
            
            //___________________________
            //___________________________
            
            int i = 0;
            for(Element myList:temp)
            {
                i++;
                if(i == 1)
                {
                accross[0] = newAcrossHints[0];
                    a[0] = myList.getElementsByTag("li").first().text().substring(0, 1);
                    
                   accross[1] = newAcrossHints[1];
                    a[1] = myList.getElementsByTag("li").next().first().text().substring(0, 1);
                    
                   accross[2] = newAcrossHints[2];
                    a[2] = myList.getElementsByTag("li").next().next().first().text().substring(0, 1);
                    
               accross[3] = newAcrossHints[3];
                    a[3] = myList.getElementsByTag("li").next().next().next().first().text().substring(0, 1);
                    
             accross[4] = newAcrossHints[4];
                   a[4] = myList.getElementsByTag("li").next().next().next().next().first().text().substring(0, 1);
                   
                }else
                {
                    down[0] = newDownHints[0];
                    d[0] = myList.getElementsByTag("li").first().text().substring(0, 1);
                    
                    down[1] = newDownHints[1];
                    d[1] = myList.getElementsByTag("li").next().first().text().substring(0, 1);
                    
                    down[2] = newDownHints[2];
                    d[2] = myList.getElementsByTag("li").next().next().first().text().substring(0, 1);
                    
                    down[3] = newDownHints[3];
                    d[3] = myList.getElementsByTag("li").next().next().next().first().text().substring(0, 1);
                    
                    down[4] = newDownHints[4];
                    d[4] = myList.getElementsByTag("li").next().next().next().next().first().text().substring(0, 1);
                
                }                           
            }   
                        //___________________________
            
            String element1 = "div.Board-boardContent--1AzTH svg g g";
            
            Document doc1 = Jsoup.connect(url).userAgent("Mozilla/17.0").get();
            
            Elements temp1 = doc1.select(element1);
            
            int k = 0;

            for(Element boxList : temp1)
            {
                boxNumbers[k++] = boxList.getElementsByTag("g").text();
            } 
            

            
            String element2 = "div.Board-boardContent--1AzTH svg g g";
            
        
            Document doc2 = Jsoup.connect(url).userAgent("Mozilla/17.0").get();
            
            Elements temp2 = doc2.select(element2);
            
            int j = 0;

            for(Element boxList2 : temp2)
            {   
                //System.out.println(j++ + " " + boxList2.getAllElements());
                
                if(boxList2.getAllElements().hasClass("Cell-block--1oNaD"))
                    blockCheck[j++] = false;
                else
                    j++;

            }           
        }catch(IOException e){
            e.printStackTrace();
        }         
        
        PUZZLE puzzle_jFrame = new PUZZLE();
        puzzle_jFrame.setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed

    public void setBoxesDefault(){
        
        box2.setBackground(new java.awt.Color(204, 204, 204));
        box2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box2.setOpaque(true);

        box1.setBackground(new java.awt.Color(204, 204, 204));
        box1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box1.setOpaque(true);

        box4.setBackground(new java.awt.Color(204, 204, 204));
        box4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box4.setOpaque(true);

        box3.setBackground(new java.awt.Color(204, 204, 204));
        box3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box3.setOpaque(true);

        box0.setBackground(new java.awt.Color(204, 204, 204));
        box0.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box0.setOpaque(true);

        box5.setBackground(new java.awt.Color(204, 204, 204));
        box5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box5.setOpaque(true);

        box6.setBackground(new java.awt.Color(204, 204, 204));
        box6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box6.setOpaque(true);

        box7.setBackground(new java.awt.Color(204, 204, 204));
        box7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box7.setOpaque(true);

        box8.setBackground(new java.awt.Color(204, 204, 204));
        box8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box8.setOpaque(true);

        box9.setBackground(new java.awt.Color(204, 204, 204));
        box9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box9.setOpaque(true);

        box10.setBackground(new java.awt.Color(204, 204, 204));
        box10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box10.setOpaque(true);

        box11.setBackground(new java.awt.Color(204, 204, 204));
        box11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box11.setOpaque(true);

        box12.setBackground(new java.awt.Color(204, 204, 204));
        box12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box12.setOpaque(true);

        box13.setBackground(new java.awt.Color(204, 204, 204));
        box13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box13.setOpaque(true);

        box14.setBackground(new java.awt.Color(204, 204, 204));
        box14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box14.setOpaque(true);

        box15.setBackground(new java.awt.Color(204, 204, 204));
        box15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box15.setOpaque(true);

        box16.setBackground(new java.awt.Color(204, 204, 204));
        box16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box16.setOpaque(true);

        box17.setBackground(new java.awt.Color(204, 204, 204));
        box17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box17.setOpaque(true);

        box18.setBackground(new java.awt.Color(204, 204, 204));
        box18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box18.setOpaque(true);

        box19.setBackground(new java.awt.Color(204, 204, 204));
        box19.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box19.setOpaque(true);

        box20.setBackground(new java.awt.Color(204, 204, 204));
        box20.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box20.setOpaque(true);

        box21.setBackground(new java.awt.Color(204, 204, 204));
        box21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box21.setOpaque(true);

        box22.setBackground(new java.awt.Color(204, 204, 204));
        box22.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box22.setOpaque(true);

        box23.setBackground(new java.awt.Color(204, 204, 204));
        box23.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box23.setOpaque(true);

        box24.setBackground(new java.awt.Color(204, 204, 204));
        box24.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        box24.setOpaque(true);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PUZZLE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PUZZLE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PUZZLE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PUZZLE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                new PUZZLE().setVisible(true);
            }
        });
    }
    
    @Override
    public void run() {
        while(true){
            try{
                Calendar c = Calendar.getInstance();
                hour = c.get(Calendar.HOUR_OF_DAY);
                if(hour > 12)
                    hour = hour - 12;
                minute = c.get(Calendar.MINUTE);
                second = c.get(Calendar.SECOND);
                
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
                
                Date dat = c.getTime();
                
                timeStr = sdf.format(dat);
                
                timer_txt.setText(timeStr);
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ACCROSS_PANEL;
    private javax.swing.JPanel DOWN_PANEL;
    private javax.swing.JPanel PUZZLE_PANEL;
    private javax.swing.JPanel QUESTIONS_PANEL;
    private javax.swing.JLabel a0;
    private javax.swing.JLabel a1;
    private javax.swing.JLabel a2;
    private javax.swing.JLabel a3;
    private javax.swing.JLabel a4;
    private javax.swing.JLabel accross0;
    private javax.swing.JLabel accross1;
    private javax.swing.JLabel accross2;
    private javax.swing.JLabel accross3;
    private javax.swing.JLabel accross4;
    private javax.swing.JLabel box0;
    private javax.swing.JLabel box1;
    private javax.swing.JLabel box10;
    private javax.swing.JLabel box11;
    private javax.swing.JLabel box12;
    private javax.swing.JLabel box13;
    private javax.swing.JLabel box14;
    private javax.swing.JLabel box15;
    private javax.swing.JLabel box16;
    private javax.swing.JLabel box17;
    private javax.swing.JLabel box18;
    private javax.swing.JLabel box19;
    private javax.swing.JLabel box2;
    private javax.swing.JLabel box20;
    private javax.swing.JLabel box21;
    private javax.swing.JLabel box22;
    private javax.swing.JLabel box23;
    private javax.swing.JLabel box24;
    private javax.swing.JLabel box3;
    private javax.swing.JLabel box4;
    private javax.swing.JLabel box5;
    private javax.swing.JLabel box6;
    private javax.swing.JLabel box7;
    private javax.swing.JLabel box8;
    private javax.swing.JLabel box9;
    private javax.swing.JLabel d0;
    private javax.swing.JLabel d1;
    private javax.swing.JLabel d2;
    private javax.swing.JLabel d3;
    private javax.swing.JLabel d4;
    private javax.swing.JPanel date_time_panel;
    private javax.swing.JLabel date_txt;
    private javax.swing.JLabel down0;
    private javax.swing.JLabel down1;
    private javax.swing.JLabel down2;
    private javax.swing.JLabel down3;
    private javax.swing.JLabel down4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton reveal;
    private javax.swing.JButton start_time;
    private javax.swing.JButton stop_time;
    private javax.swing.JPanel timekeeper;
    private javax.swing.JLabel timekeeper_txt;
    private javax.swing.JLabel timer_txt;
    // End of variables declaration//GEN-END:variables
}
