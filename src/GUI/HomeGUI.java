package GUI;

import javax.swing.*;
import java.awt.*;

public class HomeGUI extends JPanel {

    public HomeGUI() {

        setBackground(Color.LIGHT_GRAY);

        setLayout(new GridLayout(6, 1));

        JLabel titleLabel = new JLabel("Welcome to our library!");
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), titleLabel.getFont().getStyle(), 18));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        add(titleLabel);

        JLabel locationLabel = new JLabel("We are located in the center of town.");
        locationLabel.setFont(new Font(locationLabel.getFont().getName(), locationLabel.getFont().getStyle(), 18));
        locationLabel.setHorizontalAlignment(JLabel.CENTER);
        add(locationLabel);

        JLabel hoursLabel = new JLabel("Our hours are 9am to 5pm, Monday through Friday.");
        hoursLabel.setFont(new Font(hoursLabel.getFont().getName(), hoursLabel.getFont().getStyle(), 18));
        hoursLabel.setHorizontalAlignment(JLabel.CENTER);
        add(hoursLabel);

        JLabel servicesLabel = new JLabel("We offer a wide range of services, including book lending, computer access, and study rooms.");
        servicesLabel.setFont(new Font(servicesLabel.getFont().getName(), servicesLabel.getFont().getStyle(), 18));
        servicesLabel.setHorizontalAlignment(JLabel.CENTER);
        add(servicesLabel);

        JLabel eventsLabel = new JLabel("We host a variety of events, including book clubs, author talks, and workshops.");
        eventsLabel.setFont(new Font(eventsLabel.getFont().getName(), eventsLabel.getFont().getStyle(), 18));
        eventsLabel.setHorizontalAlignment(JLabel.CENTER);
        add(eventsLabel);

        JLabel membershipLabel = new JLabel("Membership is free for all residents of our community.");
        membershipLabel.setFont(new Font(membershipLabel.getFont().getName(), membershipLabel.getFont().getStyle(), 18));
        membershipLabel.setHorizontalAlignment(JLabel.CENTER);
        add(membershipLabel);


    }

}
