package demo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GPA Calculator");
        frame.setVisible(true);
        frame.setSize(800, 400);
        frame.setLayout(new FlowLayout());
        JLabel Description = new JLabel("GPA Calculator for Anna University R-2021, If you want to calculate Cgpa \n1.Enter number of Semester instead of subjects\n2. Enter total Credits of semester");
        frame.add(Description);
        JLabel numSubjectsLabel = new JLabel("Enter the number of subjects:");
        JTextField numSubjectsText = new JTextField(10);
        frame.add(numSubjectsLabel);
        frame.add(numSubjectsText);

        JButton submitButton = new JButton("Submit");
        frame.add(submitButton);

        
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int numSubjects = Integer.parseInt(numSubjectsText.getText());

                double totalCredits = 0.0;
                double totalWeightedGPA = 0.0;

                for (int i = 1; i <= numSubjects; i++) {
                    String creditsInput = JOptionPane.showInputDialog("Enter credits for Subject " + i);
                    double credits = Double.parseDouble(creditsInput);
                    
                    String grade = JOptionPane.showInputDialog("Enter grade (Anna University-R2021) for Subject " + i);
                    double gpa = getGPAScore(grade); 
                    
                    totalCredits += credits;
                    totalWeightedGPA += credits * gpa;
                }

                double overallGPA = totalWeightedGPA / totalCredits;
                JOptionPane.showMessageDialog(frame, "Overall GPA: " + overallGPA);
            }
        });
    }

    
    private static double getGPAScore(String grade) {
        
    	switch(grade) {
    	case "O" ->{
    		return 10;
    	}
    	case "A+" ->{
    		return 9;
    	}
    	case "A" ->{
    		return 8;
    	}
    	case "B+" ->{
    		return 7;
    	}
    	case "B" ->{
    		return 6;
    	}
    	case "C" ->{
    		return 5;
    	}
    	default ->{
    		return 0;
    	}
    	}
    	

    }
}
