package programa;

import java.util.Date;

import utils.utils;

public class Cliente {

    private static int counter = 1;

    private int numeroPessoa ;
    private String name;
    private String cpf;
    private String email;
    private Date accountCreationDate;

    public Cliente() { }

    public Cliente(String name, String cpf, String email) {
        this.numeroPessoa = Cliente.counter;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.accountCreationDate = new Date();
        Cliente.counter += 1;
    }

    public int getNumeroPessoa() {
        return this.numeroPessoa;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getAccountCreationDate() {
        return this.accountCreationDate;
    }

    public String toString() {
        return  "\nName: " + this.getName() +
                "\nCPF: " + this.getCpf() +
                "\nEmail: " + this.getEmail() +
                "\nAccount Creation Date: " + utils.dateToString(this.getAccountCreationDate());
    }


}
