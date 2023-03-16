/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogot� - Colombia)
 * Departamento de Tecnolog�as de la Informaci�n y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Central de Pacientes.
 * Adaptado de CUPI2 (Uniandes)
 * Fecha: Febrero 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package centralPacientes.mundo;

import java.util.ArrayList;

/**
 * Esta clase representa una central en la que se maneja una lista de pacientes
 */
public class CentralPacientes {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Lista de pacientes
     */
    private ArrayList<Paciente> pacientes;

    /**
     * Vector de cl�nicas manejadas por la central
     */
    private ArrayList<String> listaClinicas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea una nueva central sin pacientes y con una lista predefinida de cl�nicas
     */
    public CentralPacientes() {
        pacientes = new ArrayList<>();

        listaClinicas = new ArrayList<>();
        listaClinicas.add("Cl�nica del Country");
        listaClinicas.add("Cl�nica Palermo");
        listaClinicas.add("Cl�nica Reina Sof�a");
        listaClinicas.add("Cl�nica El Bosque");
        listaClinicas.add("Cl�nica San Ignacio");
        listaClinicas.add("Otra");
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el n�mero de pacientes de la cl�nica
     *
     * @return El n�mero de pacientes de la cl�nica
     */
    public int darNumeroPacientes() {
        return pacientes.size();
    }

    /**
     * Adiciona un paciente al principio de la lista
     *
     * @param pac El paciente a ser agregado al comienzo de la lista. <br>
     *            pac!=null y no existe un paciente con c�digo igual a pac.codigo
     */
    public void agregarPacienteAlComienzo(Paciente pac) {

        pacientes.add(0, pac);

        // TODO: Realiar el m�todo que agrega al principio
    }

    /**
     * Adiciona un paciente al final de la lista. Si la lista est� vac�a el paciente queda de primero
     *
     * @param pac El paciente a ser agregado al final la lista. <br>
     *            pac!=null y no existe un paciente con c�digo igual a pac.codigo
     */
    public void agregarPacienteAlFinal(Paciente pac) {
        pacientes.add(pac);

        // TODO: Agragar un paciente al final de la lista
    }

    /**
     * Adiciona un paciente a la lista de pacientes antes del paciente con el c�digo especificado. <br>
     */
    public void agregarPacienteAntesDe(int cod, Paciente pac) throws NoExisteException {
        int index = -1;
        for (int i = 0; i < pacientes.size(); i++) {
            Paciente p = pacientes.get(i);
            if (p.darCodigo() == cod) {
                index = i;
                break;
            }
        }

        // Si se encontr� el paciente, agregar el nuevo paciente antes de �l
        if (index != -1) {
            pacientes.add(index, pac);
        } else {
            throw new NoExisteException(cod);
        }

        // TODO: Agrega un paciente despu�s del paciente con el c�digo dado
    }

    /**
     * Adiciona un paciente a la lista de pacientes despu�s del paciente con el c�digo especificado.
     */
    public void agregarPacienteDespuesDe(int cod, Paciente pac) throws NoExisteException {
        boolean pacienteEncontrado = false;
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).darCodigo() == cod) {
                pacientes.add(i + 1, pac);
                pacienteEncontrado = true;
                break;
            }
        }
        if (!pacienteEncontrado) {
            throw new NoExisteException(cod);
        }

        // TODO: Agrega un paciente despu�s del paciente con el c�digo cod
    }

    /**
     * Busca el paciente con el c�digo dado en la lista de pacientes.
     */
    public Paciente localizar(int codigo) {
        return null;
    }

    /**
     * Elimina el paciente con el c�digo especificado.
     */
    public void eliminarPaciente(int cod) throws NoExisteException {
            boolean encontrado = false;
            int pos = 0;
            for (int i = 0; i < pacientes.size(); i++) {
                if (pacientes.get(i).darCodigo() == cod) {
                    encontrado = true;
                    pos = i;
                    break;
                }
            }
            if (encontrado) {
                pacientes.remove(pos);
            } else {
                throw new NoExisteException(cod);
            }

        // TODO: Si no existe el paciente con el c�digo dado, genera la excepci�n
    }

    /**
     * Devuelve una lista con los pacientes de la central
     */
    public ArrayList<Paciente> darPacientes() {
        return pacientes;
    }

    /**
     * Retorna la lista de cl�nicas manejadas por la central
     */
    public ArrayList<String> darListaClinicas() {
        return listaClinicas;
    }

    /**
     * Retorna la longitud de la lista
     */
    private int darLongitud() {
        return pacientes.size();
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * Retorna la cantidad de hombres que hay en la lista
     */
    public int cantHombres() {
        int hombres = 0;
        for (Paciente pac : pacientes) {
            if (pac.darSexo() == Paciente.HOMBRE) {
                hombres++;
            }
        }
        return hombres;
    }

    /**
     * Retorna la cantidad de mujeres que hay en la lista
     */
    public int cantMujeres() {
        int mujeres = 0;
        for (Paciente p : pacientes) {
            if (p.darSexo() == Paciente.MUJER) {
                mujeres++;
            }
        }
        return mujeres;
    }

    /**
     * De las 6 opciones de cl�nicas que tiene la central
     * �Cu�l es el nombre de la m�s ocupada, la que tiene m�s pacientes?
     *
     * @return nombre de la cl�nica
     */
    public String metodo4() {

        String[] clinicas = {"Cl�nica del Country", "Cl�nica Palermo", "Cl�nica Reina Sof�a", "Cl�nica El Bosque", "Cl�nica San Ignacio", "Otra"};


        int[] pacientesPorClinica = new int[6];


        for (Paciente paciente : pacientes) {
            for (int i = 0; i < clinicas.length; i++) {
                if (paciente.darClinica().equals(clinicas[i])) {
                    pacientesPorClinica[i]++;
                }
            }
        }


        int indiceClinicaMasOcupada = 0;
        for (int i = 1; i < pacientesPorClinica.length; i++) {
            if (pacientesPorClinica[i] > pacientesPorClinica[indiceClinicaMasOcupada]) {
                indiceClinicaMasOcupada = i;
            }
        }


        return clinicas[indiceClinicaMasOcupada];
    }


}
