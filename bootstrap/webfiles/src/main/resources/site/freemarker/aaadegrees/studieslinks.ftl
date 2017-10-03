<#include "../include/imports.ftl">

<#-- @ftlvariable name="studiesList" type="java.util.List<HippoBean>" -->

<div class="component-list">
  <a class="anchor" id="quisque-maximus-turpis" name="quisque-maximus-turpis" class="anchor" data-name="Maximus turpis"></a>
  <header>
    <span class="chapeau">${chapeau}</span>
    <h2>${title}</h2>
  </header>
  <ul class="list">
    <#list studiesList as study>
        <#assign pathVar="opleidingen/"+study.name>
      <li><a href="<@hst.link path=pathVar/>">${study.displayName}</a></li>
    </#list>
  </ul>
</div>
