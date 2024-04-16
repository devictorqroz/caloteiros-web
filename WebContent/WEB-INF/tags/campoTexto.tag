<%@ attribute name="id" required="true" %>
<%@ attribute name="label" required="true" %>
<%@ attribute name="campoName" required="true" %>
<%@ attribute name="value" required="false" %>


<label for="${id}">${label}</label>
<input type="text" name="${campoName}" id="${id}" value="${value}"/>
