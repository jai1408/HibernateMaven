<%@page import="com.hibernate.StoreData"%>
<jsp:useBean id="obj" class="com.hibernate.Employee">
</jsp:useBean>
<jsp:setProperty property="*" name="obj" />

<%  
    int i=StoreData.register(obj);  
    if(i>0)  
    out.print("You are successfully saved");  
      
    %>
