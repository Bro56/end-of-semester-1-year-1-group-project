/*
 * ============================================================
 *  FARM MANAGEMENT APP
 *  Group 12
 * ============================================================
 *
 *  Group Members
 *  ------------------------------------------------------------
 *  #   Full Name                      Registration Number
 *  ------------------------------------------------------------
 *  1   MUWANGUZI JOSHUA SSENTAMU      26/U/03580/PSA
 *  2   NAMIRIMU STACY MARTHA          26/U/03608/PS
 *  3   NAMIREMBE SCOVIA               26/U/036O7/PSA
 *  4   ANYII DAVID                    26/U/30784
 *  5   HASSAN ABBASS                  26/x/26370/ps
 *  6   OMARA GERALD JEREMIAH          25/U/26622
 *  ------------------------------------------------------------
 */


import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FarmGUI extends JFrame {

    // Backend Core Managers
    private InventoryManager inventoryManager = new InventoryManager();
    private TransactionManager transactionManager = new TransactionManager();
    // FIX 1: use the manager class (WorkersManager), not the single Worker class
    private WorkersManager workersManager = new WorkersManager();

    // Containers for dynamic cards
    private JPanel cropCardsPanel = new JPanel(new GridLayout(0, 3, 10, 10));
    private JPanel animalCardsPanel = new JPanel(new GridLayout(0, 3, 10, 10));
    private JPanel inventoryCardsPanel = new JPanel(new GridLayout(0, 3, 10, 10));
    private JPanel workerCardsPanel = new JPanel(new GridLayout(0, 3, 10, 10));

    // Transaction Table & Summary Panel Components
    private DefaultTableModel transactionTableModel;
    private JLabel totalIncomeLabel = new JLabel("Total Income: UGX 0.0");
    private JLabel totalExpenseLabel = new JLabel("Total Expenses: UGX 0.0");
    private JLabel netProfitLabel = new JLabel("Net Profit: UGX 0.0");

    public FarmGUI() {
        setTitle("AGRO MOBILE - Enkumbi Telimba Farm System");
        setSize(1150, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("SansSerif", Font.BOLD, 14));

        tabbedPane.addTab("Home", createHomeTab());
        tabbedPane.addTab("Crops", createCropTab());
        tabbedPane.addTab("Animals", createAnimalTab());
        tabbedPane.addTab("Inventory", createInventoryTab());
        tabbedPane.addTab("Transactions", createTransactionTab());
        tabbedPane.addTab("Workers", createWorkerTab());

        add(tabbedPane);
    }

    // 1. HOME TAB (Blender Style + Logo + Seedling Background)
    private JPanel createHomeTab() {
        BackgroundPanel homePanel = new BackgroundPanel("Early Stages Of Plant Growth Background.jpeg");

        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setOpaque(false);
        topBar.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JLabel logoLabel = new JLabel();
        try {
            ImageIcon logoIcon = new ImageIcon(new ImageIcon("Gemini_Generated_Image_lx1xgylx1xgylx1x.jpeg")
                    .getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH));
            logoLabel.setIcon(logoIcon);
        } catch (Exception e) {
            logoLabel.setText("AGRO MOBILE");
            logoLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
            logoLabel.setForeground(Color.WHITE);
        }

        topBar.add(logoLabel, BorderLayout.WEST);

        JPanel heroPanel = new JPanel();
        heroPanel.setLayout(new BoxLayout(heroPanel, BoxLayout.Y_AXIS));
        heroPanel.setOpaque(false);
        heroPanel.setBorder(BorderFactory.createEmptyBorder(40, 50, 20, 50));

        JLabel mainTitle = new JLabel("Agro Mobile 1.0 Edition");
        mainTitle.setFont(new Font("SansSerif", Font.BOLD, 42));
        mainTitle.setForeground(Color.WHITE);

        JLabel subTitle = new JLabel("Enkumbi Telimba - Next Gen Smart Agriculture & Farm Management Engine");
        subTitle.setFont(new Font("SansSerif", Font.PLAIN, 18));
        subTitle.setForeground(new Color(220, 220, 220));

        heroPanel.add(mainTitle);
        heroPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        heroPanel.add(subTitle);

        homePanel.add(topBar, BorderLayout.NORTH);
        homePanel.add(heroPanel, BorderLayout.CENTER);

        return homePanel;
    }

    // 2. CROP TAB
    private JPanel createCropTab() {
        BackgroundPanel panel = new BackgroundPanel("Early Stages Of Plant Growth Background.jpeg");

        JPanel formPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        formPanel.setOpaque(false);

        JTextField nameField = new JTextField(10);
        JTextField typeField = new JTextField(10);
        JTextField qtyField = new JTextField(6);
        JButton addBtn = new JButton("Add Crop Farm");

        formPanel.add(new JLabel("Crop Name:")); formPanel.add(nameField);
        formPanel.add(new JLabel("Crop Type:")); formPanel.add(typeField);
        formPanel.add(new JLabel("Quantity:")); formPanel.add(qtyField);
        formPanel.add(addBtn);

        cropCardsPanel.setOpaque(false);
        JScrollPane scrollPane = new JScrollPane(cropCardsPanel);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);

        addBtn.addActionListener(e -> {
            try {
                String name = nameField.getText();
                String type = typeField.getText();
                double qty = Double.parseDouble(qtyField.getText());

                JPanel card = createCardPanel("Crop Entry", "Name: " + name, "Type: " + type, "Quantity Produced: " + qty);
                cropCardsPanel.add(card);
                cropCardsPanel.revalidate();
                cropCardsPanel.repaint();

                nameField.setText(""); typeField.setText(""); qtyField.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numeric quantity!");
            }
        });

        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    // 3. ANIMAL TAB
    private JPanel createAnimalTab() {
        BackgroundPanel panel = new BackgroundPanel("Early Stages Of Plant Growth Background.jpeg");

        JPanel formPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        formPanel.setOpaque(false);

        JComboBox<String> typeCombo = new JComboBox<>(new String[]{"Cow", "Goat", "Chicken"});
        JTextField breedField = new JTextField(10);
        JTextField qtyField = new JTextField(6);
        JButton addBtn = new JButton("Add Animal Farm");

        formPanel.add(new JLabel("Type:")); formPanel.add(typeCombo);
        formPanel.add(new JLabel("Breed:")); formPanel.add(breedField);
        formPanel.add(new JLabel("Output Qty:")); formPanel.add(qtyField);
        formPanel.add(addBtn);

        animalCardsPanel.setOpaque(false);
        JScrollPane scrollPane = new JScrollPane(animalCardsPanel);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);

        addBtn.addActionListener(e -> {
            try {
                String type = (String) typeCombo.getSelectedItem();
                String breed = breedField.getText();
                double qty = Double.parseDouble(qtyField.getText());

                JPanel card = createCardPanel("Animal Entry", "Type: " + type, "Breed: " + breed, "Output Produced: " + qty);
                animalCardsPanel.add(card);
                animalCardsPanel.revalidate();
                animalCardsPanel.repaint();

                breedField.setText(""); qtyField.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid quantity!");
            }
        });

        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    // 4. INVENTORY TAB
    private JPanel createInventoryTab() {
        BackgroundPanel panel = new BackgroundPanel("Early Stages Of Plant Growth Background.jpeg");

        JPanel formPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 10));
        formPanel.setOpaque(false);

        JTextField nameField = new JTextField(8);
        JTextField qtyField = new JTextField(5);
        JTextField unitField = new JTextField(5);
        JTextField reorderField = new JTextField(5);
        JTextField locationField = new JTextField(8);
        JButton addBtn = new JButton("Add Inventory Item");

        formPanel.add(new JLabel("Item:")); formPanel.add(nameField);
        formPanel.add(new JLabel("Qty:")); formPanel.add(qtyField);
        formPanel.add(new JLabel("Unit:")); formPanel.add(unitField);
        formPanel.add(new JLabel("Reorder:")); formPanel.add(reorderField);
        formPanel.add(new JLabel("Location:")); formPanel.add(locationField);
        formPanel.add(addBtn);

        inventoryCardsPanel.setOpaque(false);
        JScrollPane scrollPane = new JScrollPane(inventoryCardsPanel);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);

        addBtn.addActionListener(e -> {
            try {
                String name = nameField.getText();
                double qty = Double.parseDouble(qtyField.getText());
                String unit = unitField.getText();
                double reorder = Double.parseDouble(reorderField.getText());
                String location = locationField.getText();

                JPanel card = createCardPanel("Inventory: " + name,
                        "Quantity: " + qty + " " + unit,
                        "Reorder Level: " + reorder,
                        "Location: " + location);

                inventoryCardsPanel.add(card);
                inventoryCardsPanel.revalidate();
                inventoryCardsPanel.repaint();

                nameField.setText(""); qtyField.setText(""); unitField.setText("");
                reorderField.setText(""); locationField.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Please check numeric inventory inputs!");
            }
        });

        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    // 5. TRANSACTIONS TAB (Table + Summary Panel at Bottom)
    private JPanel createTransactionTab() {
        BackgroundPanel panel = new BackgroundPanel("Early Stages Of Plant Growth Background.jpeg");

        JPanel formPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 10));
        formPanel.setOpaque(false);

        JTextField dateField = new JTextField("2026-03-30", 8);
        JComboBox<String> typeCombo = new JComboBox<>(new String[]{"Income", "Expense"});
        JTextField categoryField = new JTextField(8);
        JTextField detailsField = new JTextField(10);
        JTextField amountField = new JTextField(7);
        JButton addBtn = new JButton("Record Transaction");

        formPanel.add(new JLabel("Date:")); formPanel.add(dateField);
        formPanel.add(new JLabel("Type:")); formPanel.add(typeCombo);
        formPanel.add(new JLabel("Category:")); formPanel.add(categoryField);
        formPanel.add(new JLabel("Details:")); formPanel.add(detailsField);
        formPanel.add(new JLabel("Amount (UGX):")); formPanel.add(amountField);
        formPanel.add(addBtn);

        String[] columns = {"Date", "Type", "Category", "Details", "Amount (UGX)"};
        transactionTableModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(transactionTableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel summaryPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 15));
        summaryPanel.setBackground(new Color(30, 30, 30, 220));

        totalIncomeLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        totalIncomeLabel.setForeground(Color.GREEN);
        totalExpenseLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        totalExpenseLabel.setForeground(Color.RED);
        netProfitLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
        netProfitLabel.setForeground(Color.CYAN);

        summaryPanel.add(totalIncomeLabel);
        summaryPanel.add(totalExpenseLabel);
        summaryPanel.add(netProfitLabel);

        addBtn.addActionListener(e -> {
            try {
                String date = dateField.getText();
                String type = (String) typeCombo.getSelectedItem();
                String category = categoryField.getText();
                String details = detailsField.getText();
                double amount = Double.parseDouble(amountField.getText());

                transactionManager.addTransaction(date, type, category, details, amount);
                transactionTableModel.addRow(new Object[]{date, type, category, details, "UGX " + amount});

                totalIncomeLabel.setText("Total Income: UGX " + transactionManager.getTotalIncome());
                totalExpenseLabel.setText("Total Expenses: UGX " + transactionManager.getTotalExpenses());
                netProfitLabel.setText("Net Profit: UGX " + transactionManager.getNetProfit());

                categoryField.setText(""); detailsField.setText(""); amountField.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid numeric amount!");
            }
        });

        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(summaryPanel, BorderLayout.SOUTH);

        return panel;
    }

    // 6. WORKERS TAB (Overloaded salary payments and array storage)
    private JPanel createWorkerTab() {
        BackgroundPanel panel = new BackgroundPanel("Early Stages Of Plant Growth Background.jpeg");

        JPanel formPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 10));
        formPanel.setOpaque(false);

        JTextField nameField = new JTextField(8);
        JTextField roleField = new JTextField(8);
        JTextField contactField = new JTextField(8);
        JTextField salaryField = new JTextField(6);
        JButton addBtn = new JButton("Add / Update Worker");

        formPanel.add(new JLabel("Name:")); formPanel.add(nameField);
        formPanel.add(new JLabel("Role:")); formPanel.add(roleField);
        formPanel.add(new JLabel("Contact:")); formPanel.add(contactField);
        formPanel.add(new JLabel("Salary (UGX):")); formPanel.add(salaryField);
        formPanel.add(addBtn);

        workerCardsPanel.setOpaque(false);
        JScrollPane scrollPane = new JScrollPane(workerCardsPanel);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);

        addBtn.addActionListener(e -> {
            try {
                String name = nameField.getText().trim();
                String role = roleField.getText();
                String contact = contactField.getText();
                double salary = Double.parseDouble(salaryField.getText());

                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter the worker's name!");
                    return;
                }

                // FIX 2: addWorker() takes a Worker object, not 4 separate values.
                // If a worker with this name exists, update them; otherwise add a new one.
                Worker existing = workersManager.getWorkerByName(name);
                if (existing != null) {
                    existing.setRole(role);
                    existing.setContact(contact);
                    existing.setSalary(salary);
                } else {
                    boolean added = workersManager.addWorker(new Worker(name, role, contact, salary));
                    if (!added) {
                        JOptionPane.showMessageDialog(this, "Worker list is full (max 100)!");
                        return;
                    }
                }
                refreshWorkerCards();

                nameField.setText(""); roleField.setText(""); contactField.setText(""); salaryField.setText("");
                JOptionPane.showMessageDialog(this, "Worker saved/updated successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Please verify worker inputs!");
            }
        });

        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    private void refreshWorkerCards() {
        workerCardsPanel.removeAll();
        // FIX 3: the class is Worker, there is no WorkerRecord class
        for (Worker w : workersManager.getWorker()) {
            JPanel card = new JPanel();
            card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
            card.setBackground(new Color(255, 255, 255, 225));
            card.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(34, 139, 34), 2),
                    BorderFactory.createEmptyBorder(10, 10, 10, 10)
            ));

            card.add(new JLabel("<html><b>Name:</b> " + w.getName() + "</html>"));
            card.add(new JLabel("<html><b>Role:</b> " + w.getRole() + "</html>"));
            card.add(new JLabel("<html><b>Contact:</b> " + w.getContact() + "</html>"));
            card.add(new JLabel("<html><b>Salary:</b> UGX " + w.getSalary() + "</html>"));

            JButton payBtn = new JButton("Pay Salary");
            payBtn.addActionListener(e -> {
                String[] methods = {"Cash (Default)", "Mobile Money", "Bank"};
                String method = (String) JOptionPane.showInputDialog(this, "Select Payment Method:",
                        "Pay Salary", JOptionPane.QUESTION_MESSAGE, null, methods, methods[0]);

                if (method != null) {
                    String receipt;
                    if (method.equals("Cash (Default)")) {
                        receipt = w.paySalary(w.getSalary()); // Overloaded Method 1
                    } else if (method.equals("Mobile Money")) {
                        String phone = JOptionPane.showInputDialog("Enter Mobile Money Number:");
                        if (phone == null) return; // user cancelled
                        receipt = w.paySalary(w.getSalary(), "Mobile Money", phone); // Overloaded Method 3
                    } else {
                        String bankAcc = JOptionPane.showInputDialog("Enter Bank Account Number:");
                        if (bankAcc == null) return; // user cancelled
                        receipt = w.paySalary(w.getSalary(), "Bank Transfer", bankAcc); // Overloaded Method 3
                    }
                    JOptionPane.showMessageDialog(this, receipt);
                }
            });

            card.add(Box.createRigidArea(new Dimension(0, 5)));
            card.add(payBtn);
            workerCardsPanel.add(card);
        }
        workerCardsPanel.revalidate();
        workerCardsPanel.repaint();
    }

    private JPanel createCardPanel(String title, String l1, String l2, String l3) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(new Color(255, 255, 255, 225));
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(34, 139, 34), 2),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        JLabel t = new JLabel(title);
        t.setFont(new Font("SansSerif", Font.BOLD, 14));
        t.setForeground(new Color(0, 100, 0));

        card.add(t);
        card.add(Box.createRigidArea(new Dimension(0, 5)));
        card.add(new JLabel(l1));
        card.add(new JLabel(l2));
        card.add(new JLabel(l3));

        return card;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FarmGUI().setVisible(true);
        });
    }
}