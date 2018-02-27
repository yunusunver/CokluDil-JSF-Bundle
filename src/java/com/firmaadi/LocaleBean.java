package com.firmaadi;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

@ManagedBean(name = "dil")
@SessionScoped
public class LocaleBean {

    private String yerelDurum;
    private Map<String, Object> ulkelerHaritasi;

    public String getYerelDurum() {
        return yerelDurum;
    }

    public void setYerelDurum(String yerelDurum) {
        this.yerelDurum = yerelDurum;
    }

    public Map<String, Object> getUlkelerHaritasi() {
        return ulkelerHaritasi;
    }

    public void setUlkelerHaritasi(Map<String, Object> ulkelerHaritasi) {
        this.ulkelerHaritasi = ulkelerHaritasi;
    }
    
    //hazırlayıcı olarak ilk değerleri verir
    public LocaleBean() {
        ulkelerHaritasi = new LinkedHashMap<String, Object>();
        ulkelerHaritasi.put("Türkçe", new Locale("tr", "TR"));
        ulkelerHaritasi.put("English", new Locale("en", "GB"));
    }

    //Dili seçtiğimiz zaman çağırılan metod.Seçtiğimiz zaman devreye girer.
    public void yerelDurumDegisiminiKontrolEt(ValueChangeEvent e) {
        String localeStr = e.getNewValue().toString();

        for (Map.Entry<String, Object> entry : ulkelerHaritasi.entrySet()) {
            if (entry.getValue().toString().equals(localeStr)) {
                Locale locale = (Locale) entry.getValue();
                FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
            }

        }
    }
}
