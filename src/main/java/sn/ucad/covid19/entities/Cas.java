package sn.ucad.covid19.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cas {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
    @Column(length=200)
  private String ville;
    @Column(length =200)
  private String quartier;
    @Temporal(TemporalType.DATE)
  private Date date;
}
