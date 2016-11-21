/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danubiusinfo.ejb;

import com.danubiusinfo.entity.Category;
import com.danubiusinfo.entity.ErrorMessage;
import com.danubiusinfo.entity.Language;
import com.danubiusinfo.entity.Words;
import com.danubiusinfo.exception.DataNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author kovacs_tamas
 */
@Stateless
public class CommonControllerImpl implements CommonController {

    @PersistenceContext(unitName = "KikerdezoPU")
    private EntityManager em;

    @Override
    public List<Words> getAllFromCateg(int categId) {

        Query qry = em.createNamedQuery("Words.findByCategId", Words.class)
                .setParameter("categId", categId);

        List<Words> words = qry.getResultList();
        if (words == null || words.isEmpty()) {
            throw new DataNotFoundException("Nincs ilyen kategória: " + categId);
        }
        return words;
    }

    @Override
    public Words getOneWord(int id) {

        // List<Words> word = ArrayList<>();
        Query qry = em.createNamedQuery("Words.findById", Words.class)
                .setParameter("id", id);
        List<Words> word = qry.getResultList();

        if (word == null || word.isEmpty()) {
            throw new DataNotFoundException("Nincs ilyen ID: " + id);
        }
        return word.get(0);
    }

    @Override
    public List<Category> getAllCateg() {

        Query qry = em.createNamedQuery("Category.AllCateg");
        List<Category> AllNeeded = qry.getResultList();
        return AllNeeded;
    }

    @Override
    public List<Words> getAllLang(int langId) {

        Query qry = em.createNamedQuery("Words.findAllFromLang", Words.class)
                .setParameter("langId", langId);
        List<Words> AllNeeded = qry.getResultList();

        if (AllNeeded == null || AllNeeded.isEmpty()) {
            throw new DataNotFoundException("Nincs ilyen nyelvid " + langId);
        }
        return AllNeeded;

    }

    @Override
    public Words createWord(String hMean1, String hMean2, String fMean, int categId, int langId) {

        Words word = new Words();

        word.setCategId(categId);
        word.setLangId(langId);
        word.setfMean(fMean);
        word.sethMean1(hMean1);
        word.sethMean2(hMean2);

        em.persist(word);
        em.flush();
        return word;

    }

    @Override
    public Words updateWord(int id, String hMean1, String hMean2, String fMean) {
        // ezt nem ide kéne tenni
        ErrorMessage errorMessage = new ErrorMessage(404,"Nincs ilyen ID", "http://danubiusinfo.hu");   //Applikáció exceptionhoz kell csinálni egy response-t
        Response response =  Response.status(Status.NOT_FOUND)
                .entity(errorMessage)
                .build();

        Words word = em.find(Words.class, id);
        if(word == null){                   // JAX-WS alap applikáció exception osztálya - nem kell genericet csinálni
            throw new WebApplicationException(response);
        }
        word.setfMean(fMean);
        word.sethMean1(hMean1);
        word.sethMean2(hMean2);

        em.merge(word);
        em.flush();
        
        return word;
    }

    @Override
    public boolean deleteWord(int id) {

        boolean result = false;
//     
//     Words word = em.find(Words.class, id);
//     if (word == null){
//         result = false;
//         return result;
//     }
//
//    em.remove(word);
//    em.persist(word);
//    em.flush();
//    result = true;
        Query qry = em.createNamedQuery("Words.delete", Words.class)
                .setParameter("id", id);
        int deletedNumber = qry.executeUpdate();
        if (deletedNumber == 1) {
            result = true;
            return result;
        }
        return result;
    }

    @Override
    public List<Words> getAllPaginated(int categId, int start, int size) {

        Query qry = em.createNamedQuery("Words.findByCategId", Words.class)
                .setParameter("categId", categId);

        List<Words> words = qry.getResultList();

        return words.subList(start, start + size);

    }

    @Override
    public List<Language> getAllLanguageName(int start, int size) {

        Query qry = em.createNamedQuery("Language.findAllFromLang", Language.class);
        List<Language> langs = qry.getResultList();

        return langs.subList(start, size);
    }

}
