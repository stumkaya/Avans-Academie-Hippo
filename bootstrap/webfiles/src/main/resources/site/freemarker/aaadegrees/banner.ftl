<#include "../include/imports.ftl">
<#setting locale="nl_NL">
<#setting date_format="d MMMM">
<#if document??>
<div class="component-hero" data-image="<@hst.link hippobean=document.image/>" data-image-xs="<@hst.link hippobean=document.mobileimage/>">
  <div class="container">
    <div class="row banner">
      <div class="col-xs-5  col-sm-4">
          <@hst.html hippohtml=document.content/>
      </div>

      <div class="col-xs-7 col-sm-8">

      </div>
    </div>
    <div class="row text">
      <div class="col-xs-12 col-md-4">
        <header>
          <#if document.title??><h1>${document.title}</h1></#if>
            <#if document.subtitle??><p>${document.subtitle}</p></#if>
        </header>
        <div>
          <#if document.cta??><a href="#" class="btn btn-primary scrollpast">${document.cta}</a></#if>
          <ul class="link-list white">
            <#if document.link??><li><a href="<@hst.link hippobean=document.link/>"><#if document.linktext??>${document.linktext}</#if></a></li></#if>
            <li><#if document.linkurl??><a href="${document.linkurl}">Aanmelden</a></#if></li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</div>

</#if>


<@hst.headContribution category="htmlBodyEnd">
<script type="text/javascript" src="<@hst.webfile path="/js/vendor/jquery.min.js" />"></script>
</@hst.headContribution>
<@hst.headContribution category="htmlBodyEnd">
<script type="text/javascript" src="<@hst.webfile path="/js/vendor/bootstrap.min.js" />"></script>
</@hst.headContribution>
<@hst.headContribution category="htmlBodyEnd">
<script type="text/javascript" src="<@hst.webfile path="/js/vendor/jquery.cycle2.min.js" />"></script>
</@hst.headContribution>
<@hst.headContribution category="htmlBodyEnd">
<script type="text/javascript" src="<@hst.webfile path="/js/scripts.min.js" />"></script>
</@hst.headContribution>

