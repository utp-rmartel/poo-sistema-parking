/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import java.util.List;

/**
 *
 * @author Royss
 */
public interface IBaseDAO<T> {
    public int Create(T input);
    public T Read(String id);  
    public List<T> ReadAll();  
    public int Update(T input);  
    public int Delete(String id);  
}
