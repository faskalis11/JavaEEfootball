package lt.vu;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.persistence.criteria.CriteriaBuilder;

import lt.vu.mybatis.dao.TeamMapper;
import lt.vu.mybatis.model.Team;


@FacesConverter("teamConverterMB")
public class TeamConverterMB implements Converter {

    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                TeamMapper service = (TeamMapper) fc.getExternalContext().getApplicationMap().get("teamService");
                return service.selectAll().get(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        else {
            return null;
        }
    }

    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((Team) object).getId());
        }
        else {
            return null;
        }
    }
}

