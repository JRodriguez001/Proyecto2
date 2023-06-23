/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author david
 */
public class InformacionPersonal {

    String nombre;
    int edad = 0;
    boolean ter = true;

    public InformacionPersonal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isTer() {
        return ter;
    }

    public void setTer(boolean ter) {
        this.ter = ter;
    }

    public void Verificar(int age) {
        if (age > 7) {
            System.out.println("Puede participar");
            ter = true;
        } else {
            System.out.println("No se puede jugar, tiene que tener mas de 8 anos");
            ter = false;
        }

    }

    @Override
    public String toString() {
        return "InformacionPersonal{" + "nombre=" + nombre + ", edad=" + edad + '}';
    }

}
