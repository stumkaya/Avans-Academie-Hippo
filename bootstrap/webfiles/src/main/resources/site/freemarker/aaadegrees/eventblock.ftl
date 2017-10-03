<#include "../include/imports.ftl">
<#-- @ftlvariable name="document" type="nl.avans.beans.EventsDocument" -->

<#setting locale="nl_NL">
<#setting date_format="d MMMM">


<#if document??>
<div class="component-widget widget-red">
  <header>
    <h3 class="panel-title">${cta}</h3>
  </header>
  <div>
    <p><strong>${document.title1}</strong><br>
      ${document.date.time?date}</p>
    <ul class="link-list">
      <li><a href="<@hst.link hippobean=document/>">Meer informatie</a></li>
      <li><a href="${document.ctaUrl}">${document.cta}</a></li>
    </ul>
  </div>
</div>
<#elseif editMode>
No events will be shown. If you have picked an event, please make sure the event date is not over. *This notice text will not appear in the live site*
</#if>
