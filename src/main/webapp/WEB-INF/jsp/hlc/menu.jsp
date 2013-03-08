<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<nav class="navbar navbar-fixed-top" role="navigation">
    <ul class="nav">
        <li><a href="<c:url value='/inicio' />"><s:message code="inicio.label" /></a></li>
        <li<c:if test="${param.menu eq 'principal'}"> class="active"</c:if>><a href="<c:url value='/hlc' />"><s:message code="hlc.label" /></a></li>
        <li<c:if test="${param.menu eq 'articulo'}"> class="active"</c:if>><a href="<s:url value='/hlc/articulo'/>" ><s:message code="articulo.lista.label" /></a></li
    </ul>
</nav>
