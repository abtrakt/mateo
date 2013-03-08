<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <title><s:message code="articulo.edita.label" /></title>
    </head>
    <body>
        <jsp:include page="../menu.jsp" >
            <jsp:param name="menu" value="articulo" />
        </jsp:include>

        <div id="nuevo-articulo" class="content scaffold-list" role="main">
            <h1><s:message code="articulo.edita.label" /></h1>
            <p class="well">
                <a class="btn btn-primary" href="<s:url value='/hlc/articulo'/>"><i class="icon-list icon-white"></i> <s:message code='articulo.lista.label' /></a>
            </p>
            <c:url var="actualizaUrl" value="/hlc/articulo/graba" />
            <form:form commandName="articulo" action="${actualizaUrl}" method="post">
                <form:hidden path="id" />
                <form:hidden path="version" />
                <form:errors path="*">
                    <div class="alert alert-block alert-error fade in" role="status">
                        <a class="close" data-dismiss="alert">×</a>
                        <c:forEach items="${messages}" var="message">
                            <p>${message}</p>
                        </c:forEach>
                    </div>
                </form:errors>

                <fieldset>
                    <s:bind path="articulo.codigo">
                        <div class="control-group <c:if test='${not empty status.errorMessages}'>error</c:if>">
                            <label for="codigo">
                                <s:message code="codigo.label" />
                                <span class="required-indicator">*</span>
                            </label>
                            <form:input path="codigo" maxlength="128" required="true" cssClass="span3" />
                            <form:errors path="codigo" cssClass="alert alert-error" />
                        </div>
                    </s:bind>
                    <s:bind path="articulo.descripcion">
                        <div class="control-group <c:if test='${not empty status.errorMessages}'>error</c:if>">
                            <label for="descripcion">
                                <s:message code="descripcion.label" />
                                <span class="required-indicator">*</span>
                            </label>
                            <form:input path="descripcion" maxlength="128" required="true" cssClass="span3" />
                            <form:errors path="descripcion" cssClass="alert alert-error" />
                        </div>
                    </s:bind>
                    <s:bind path="articulo.descripcion1">
                        <div class="control-group <c:if test='${not empty status.errorMessages}'>error</c:if>">
                            <label for="descripcion1">
                                <s:message code="descripcion1.label" />
                                <span class="required-indicator">*</span>
                            </label>
                            <form:input path="descripcion1" maxlength="128" required="true" cssClass="span3" />
                            <form:errors path="descripcion1" cssClass="alert alert-error" />
                        </div>
                    </s:bind>
                    <s:bind path="articulo.sustancia">
                        <div class="control-group <c:if test='${not empty status.errorMessages}'>error</c:if>">
                            <label for="sustancia">
                                <s:message code="sustancia.label" />
                                <span class="required-indicator">*</span>
                            </label>
                            <form:input path="sustancia" maxlength="128" required="true" cssClass="span3" />
                            <form:errors path="sustancia" cssClass="alert alert-error" />
                        </div>
                    </s:bind>
                    <s:bind path="articulo.gpoProducto">
                        <div class="control-group <c:if test='${not empty status.errorMessages}'>error</c:if>">
                            <label for="gpoProducto">
                                <s:message code="gpoProducto.label" />
                                <span class="required-indicator">*</span>
                            </label>
                            <form:input path="gpoProducto" maxlength="128" required="true" cssClass="span3" />
                            <form:errors path="gpoProducto" cssClass="alert alert-error" />
                        </div>
                    </s:bind>
                    <s:bind path="articulo.um">
                        <div class="control-group <c:if test='${not empty status.errorMessages}'>error</c:if>">
                            <label for="um">
                                <s:message code="um.label" />
                                <span class="required-indicator">*</span>
                            </label>
                            <form:input path="um" maxlength="128" required="true" cssClass="span3" />
                            <form:errors path="um" cssClass="alert alert-error" />
                        </div>
                    </s:bind>
                   
                </fieldset>

                <p class="well" style="margin-top: 10px;">
                    <button type="submit" name="actualizarBtn" class="btn btn-primary btn-large" id="actualizar" ><i class="icon-ok icon-white"></i>&nbsp;<s:message code='actualizar.button'/></button>
                    <a class="btn btn-large" href="<s:url value='/hlc/articulo/ver/${articulo.id}'/>"><i class="icon-remove"></i> <s:message code='cancelar.button' /></a>
                </p>
            </form:form>
        </div>
        <content>
            <script>
                $(document).ready(function() {
                    $('input#descripcion').focus();
                });
            </script>                    
        </content>
    </body>
</html>
