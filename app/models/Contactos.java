package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity 
public class Contactos extends Model {

  @Id
  public Long id;
  
  @Constraints.Required
  public String nombre;
  
  @Constraints.Required
  public String telefono;
  
  @Constraints.Required
  public String correo_electronico;
  
  @ManyToOne
  public Usuarios usuarios;
  
  public static Finder<Long,Contactos> find = new Finder<Long,Contactos>( Long.class, Contactos.class );

}