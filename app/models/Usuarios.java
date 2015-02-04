package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import javax.persistence.ManyToOne;

@Entity 
public class Usuarios extends Model {

  @Id
  public Long id;
  
  @Constraints.Required
  public String nombre;
  
  @Constraints.Required
  public String genero;
  
  @Formats.DateTime(pattern="dd/MM/yyyy")
  public Date fecha_nacimiento = new Date();

  @Constraints.Required
  public String username;
  
  @Constraints.Required
  public String password;

  @OneToOne
  public Preguntas preguntas;

  @OneToMany(cascade=CascadeType.ALL)
  public List<Contactos> contactos;
  
  @Constraints.Required
  public String respuesta;
  
  public static Finder<Long,Usuarios> find = new Finder<Long,Usuarios>( Long.class, Usuarios.class );

}