package com.hibernate.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
public class CardDetails implements Serializable {

	public CardDetails(){
		super();
	}
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "card_id")
	int cardId=0;
	String cardType;
	String cardName;
	String status;
	int cvv;
	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
//	@JsonIgnoreProperties({"hibernatelazyinitializer ","handler "})
//	@JoinTable(name="USER_CARD",joinColumns=@JoinColumn(name="card_id"),inverseJoinColumns=@JoinColumn(name="user_id"))
	UserDetails userDetails ;
	@Override
	public String toString() {
		return "CardDetails [cardId=" + cardId + ", cardType=" + cardType + ", cardName=" + cardName + ", status="
				+ status + ", cvv=" + cvv ;
	}
	
}
