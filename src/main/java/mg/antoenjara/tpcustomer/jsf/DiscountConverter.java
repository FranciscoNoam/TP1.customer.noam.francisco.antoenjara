/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.antoenjara.tpcustomer.jsf;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.*;
import jakarta.inject.Inject;
import mg.antoenjara.tpcustomer.entities.Discount;
import mg.antoenjara.tpcustomer.service.DiscountManager;

/**
 *
 * @author francisco
 */
@FacesConverter(value = "discountConverter", managed=true)
public class DiscountConverter implements Converter<Discount> {
  @Inject
  private DiscountManager discountManager;

  /**
   * Convertit une String en Discount.
   *
   * @param value valeur à convertir
   */
  @Override
  public Discount getAsObject(FacesContext context, UIComponent component, String value) {
    if (value == null) return null;
    return discountManager.findById(value);
  }

  /**
   * Convertit un Discount en String.
   * @param value valeur à convertir
   */
  @Override
  public String getAsString(FacesContext context, UIComponent component, Discount discount) {
    if (discount == null) return "";
    return discount.getCode();
  }
}