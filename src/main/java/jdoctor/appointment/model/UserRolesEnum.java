
package jdoctor.appointment.model;


public enum UserRolesEnum {
    ADMIN("Administrador"),
    MANAGE_ROLES("Gerenciar permissões"),
    EDIT_APPOINTMENT("Editar consultas"),
    MANAGE_DOCTORS("Gerenciar Doutores"),
    MANAGE_SECRETARY("Gerenciar Secretarias"),
    MANAGE_APPOINTMENT("Gerenciar consultas"),
    CREATE_APPOINTMENT("Criar consultas"),
    REMOVE_APPOINTMENT("Remover consultas");
    
    public final String label;
    private UserRolesEnum(String label) {
        this.label = label;
    }
}
