package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity 
public class Preguntas extends Model {

  @Id
  public Long id;
  
  @Constraints.Required
  public String pregunta;
  
  @OneToOne(mappedBy="preguntas")
  public Usuarios usuarios;
  
  public static Finder<Long,Preguntas> find = new Finder<Long,Preguntas>( Long.class, Preguntas.class );

}