/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldnames;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Deon
 */
public class WorldNames extends JFrame implements ActionListener{

    public static final int WIDTH = 600;
    public static final int HEIGHT = 300;
    Font font;
    String [] countries = {"Afghanistan", "Albania", "Algeria"};
    String [] names = new String[75];
    String [] lastNames = new String[75];
    String country, first, last;
    JComboBox list;
    JPanel panel;
    JLabel name, title;
    JButton generate;
    Random rand;
    
    public WorldNames(){
        
        font = new Font("Impact", Font.PLAIN, 30);
        country = "";
        rand = new Random();
        
        panel = new JPanel();
        setTitle("Name Generator");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(panel);
        setVisible(true);
        setResizable(false);
        
        name = new JLabel("Choose a country and click generate!");
        name.setBounds(10, 60, 300, 50);
        
        title = new JLabel("Name Generator");
        title.setBounds(10, 10, WIDTH, 40);
        title.setFont(font);
        
        generate = new JButton("GENERATE");
        generate.setBounds(290, 50, WIDTH / 2 - 10, HEIGHT / 2);
        generate.setEnabled(false);
        generate.addActionListener(this);
        
        list = new JComboBox(countries);
        list.setBounds(10, 50, WIDTH / 2 - 30, 20);
        list.addActionListener(this);
        
        panel.setLayout(null);
        panel.add(name);
        panel.add(title);
        panel.add(generate);
        panel.add(list);
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       new WorldNames();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == generate){
             int nameNum = rand.nextInt(names.length);
             first = names[nameNum];
             nameNum = rand.nextInt(lastNames.length);
             last = lastNames[nameNum];
             name.setText("Name: " + first + " " + last);
             
        }
        if(e.getSource() == list){
            
            country = (String) list.getSelectedItem();
            try{
                BufferedReader br = new BufferedReader(new FileReader("countries/" + country + "First.txt"));
                String line = br.readLine();
                for(int i = 0; i < names.length; i++){
                    names[i] = line;
                    line = br.readLine();
                }
                generate.setEnabled(true);
                br.close();
            }catch(FileNotFoundException ex){
                System.out.println("Could not find the " + country + " first names file.");
                generate.setEnabled(false);
            } catch (IOException ex) {
                Logger.getLogger(WorldNames.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try{
                BufferedReader br = new BufferedReader(new FileReader("countries/" + country + "Last.txt"));
                String line = br.readLine();
                int i = 0;
                while(line != null){
                    lastNames[i] = line;
                    i++;
                    line = br.readLine();
                }
                generate.setEnabled(true);
                br.close();
            }catch(FileNotFoundException ex){
                System.out.println("Could not find the " + country + " last names file.");
                generate.setEnabled(false);
            } catch (IOException ex) {
                Logger.getLogger(WorldNames.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
}
