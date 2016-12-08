/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danubiusinfo.ejb;

import com.danubiusinfo.entity.Category;
import com.danubiusinfo.entity.Language;
import com.danubiusinfo.entity.Words;
import java.util.List;



/**
 *
 * @author kovacs_tamas
 */

public interface CommonController {
    
    public List<Words> getAllFromCateg(int categId);
    public List<Category> getAllCateg();
    public Words getOneWord(int id);
    public Words updateWord(int id,String hMean1, String hMean2, String fMean);
    public boolean deleteWord(int id);
    public List<Words> getAllLang(int langId);
    public Words createWord(String hMean1, String hMean2, String fMean, int categId, int langId);
    public List<Words> getAllPaginated(int categI, int start, int size);
    public List<Language> getAllLanguageName();
    
    
}
