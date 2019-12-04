package br.fatec.reusala;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    private Room room;
    @ManyToOne
    private User user;
    private LocalDateTime start;
    private LocalDateTime end;
    private int status;
    private String text;

}
