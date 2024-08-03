package com.ShowService.Model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name="shows")
public class Show {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String movieName;
	
	private String name;
	
	private int rate;
	
	private boolean []seats=new boolean[20];

}
