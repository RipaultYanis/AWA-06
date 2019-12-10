/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.entities;

/**
 *
 * @author root
 */
public class EvaluationConvive { 
    private int note = 2;
    private String commentaire;
    private boolean bloquer;

    public EvaluationConvive(int note,String commentaire,boolean bloquer) {
        this.note=note;
        this.commentaire = commentaire;
        this.bloquer=bloquer;
    }

    public void setBloquer(boolean bloquer) {
        this.bloquer = bloquer;
    }

    public boolean isBloquer() {
        return bloquer;
    }

    public EvaluationConvive() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setNote(int note) {
        this.note = note;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    
    public int getNote() {
        return note;
    }

    public String getCommentaire() {
        return commentaire;
    }
  
    
}
