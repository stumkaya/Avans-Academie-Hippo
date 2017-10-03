<#include "../include/imports.ftl">

<#-- @ftlvariable name="document" type="nl.avans.beans.Video" -->
<#-- @ftlvariable name="cparam" type="org.onehippo.cms7.essentials.components.info.EssentialsVideoComponentInfo"--%> -->
<#if document??>

<div class="component-youtube">
    <#if document.stickymenuitem?? && document.stickymenuitem?has_content>
        <a class="anchor" id="${document.stickymenuitem?lower_case?replace(" ", "_")}" name="${document.stickymenuitem?lower_case?replace(" ", "_")}" data-name="${document.stickymenuitem}"></a>
    </#if>
<span class="chapeau"><#if document.chapeau??>${document.chapeau?html}</#if></span>
  <div class="video-wrapper">
    <div class="video" data-video="<#if document.link??>${document.link?html}</#if>"></div>
  </div>
  <div>
    <header>
      <h2><#if document.title??>${document.title?html}</#if></h2>
    </header>
    <ul class="link-list white">
      <li><a href="<#if document.linkurl??>${document.linkurl}</#if>"><#if document.linktitle??>${document.linktitle?html}</#if></a></li>
    </ul>
  </div>
</div>

<#-- @ftlvariable name="editMode" type="java.lang.Boolean"-->
<#elseif editMode>
<img src="<@hst.link path="/images/essentials/catalog-component-icons/video.png" />"> Click to edit Video
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
<script type="text/javascript" src="<@hst.webfile path="/js/vendor/scrollspy.js" />"></script>
</@hst.headContribution>

<@hst.headContribution category="htmlBodyEnd">
<script type="text/javascript" src="<@hst.webfile path="/js/scripts.min.js" />"></script>
</@hst.headContribution>

