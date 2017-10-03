<#include "../../include/imports.ftl">
<#setting locale="nl_NL">
<#setting date_format="d MMMM">
<div class="component-content">
  <header>
      <#if document.chapeau?? && document.chapeau?has_content><span class="chapeau">Nulla non pellentesque</span></#if>
      <#if document.title?? && document.title?has_content><h2>Nunc at eleifend sapien</h2></#if>
  </header>
  <div class="row">
    <div class="col-sm-6">
        <@hst.html hippohtml=Request.document.content/>
    </div>
    <div class="col-sm-6">
        <@hst.html hippohtml=Request.document.secondcontent/>
    </div>
  </div>
