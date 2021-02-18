

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.*;
import javax.swing.JPanel;


public class Tela extends JFrame implements ActionListener {

    public static JPanel borda;
    public static JLabel lblNome, lblEmail, lblCpf;
    public static JTextField txtNome, txtEmail;
    public static JFormattedTextField txtCpf;
    public static JButton cadastrar, excluir;

    private String nome, emmai;
    private int cpf;

    public Tela() {

        super("Cadastro de clientes");

        borda = new JPanel();
        borda.setLayout(null);
        borda.setBorder(BorderFactory.createTitledBorder("Dados pessoais"));
        borda.setSize(600, 400);
        borda.setVisible(true);
        this.add(borda);

        lblNome = new JLabel("Nome: ");
        lblNome.setBounds(15, 30, 100, 30);
        borda.add(lblNome);

        lblEmail = new JLabel("Email: ");
        lblEmail.setBounds(15, 60, 100, 30);
        borda.add(lblEmail);

        lblCpf = new JLabel("CPF: ");
        lblCpf.setBounds(15, 90, 100, 30);
        borda.add(lblCpf);

        txtNome = new JTextField();
        txtNome.setBounds(110, 35, 200, 20);
        borda.add(txtNome);

        txtEmail = new JTextField();
        txtEmail.setBounds(110, 65, 200, 20);
        borda.add(txtEmail);

        txtCpf = new JFormattedTextField();
        txtCpf.setBounds(110, 95, 200, 20);
        borda.add(txtCpf);

        cadastrar = new JButton("Cadastrar");
        cadastrar.addActionListener(this);
        cadastrar.setBounds(120, 160, 100, 30);
        borda.add(cadastrar);

        excluir = new JButton("Excluir");
        excluir.setBounds(240, 160, 100, 30);
        borda.add(excluir);

        //dimensão da janela
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
//acao do botao

    @Override
    public void actionPerformed(ActionEvent ae) {

        setNome(txtNome.getText());
        setEmmai(txtEmail.getText());

        JOptionPane.showMessageDialog(null, salvar());

    }
//encapsulando

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmmai() {
        return emmai;
    }

    public void setEmmai(String emmai) {
        this.emmai = emmai;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String salvar() {

        try {
            //recebe o objeto do tipo arquivo , e pode ser acrescentdo ao inves de substituido
            FileWriter fw = new FileWriter("clientessalvos.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("Nome: " + this.getNome());
            pw.println("Email: " + this.getEmmai());
            pw.println("Cpf: " + this.getCpf());
            pw.flush();
            pw.close();
            fw.close();

        } catch (IOException ex) {
            Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "Cadastrado com sucesso";

    }

}


