import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Application extends JFrame implements ActionListener {

    private JTextArea textArea;
    private JButton countButton;

    private JLabel countLabel;

    public Application(){
        // created the  mainframe

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setTitle("Word Count Application ");
        setLocationRelativeTo(null);


        //intialize variables
        textArea = new JTextArea(10, 20);
        countButton = new JButton("Click to count");
        countLabel = new JLabel("Total Words : 0 ");

        // Title
        JLabel titleLabel = new JLabel("Word Count", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        //input panel for text area
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(new JScrollPane(textArea) , BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(countButton);
        bottomPanel.add(countLabel);


        setLayout(new BorderLayout());
        add(titleLabel, BorderLayout.NORTH); //title at the top
        add(inputPanel, BorderLayout.CENTER); //text area in the center
        add(bottomPanel, BorderLayout.SOUTH); // button and label at the bottom

        countButton.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e){
        String text = textArea.getText();

        if (!text.trim().isEmpty()){
            String[] words = text.trim().split("\\s+");
            countLabel.setText("Total Words : " + words.length);
        }
        else
            countLabel.setText("Total Words : 0");


    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            Application app = new Application();
            app.setVisible(true);
        });


        }
    }
