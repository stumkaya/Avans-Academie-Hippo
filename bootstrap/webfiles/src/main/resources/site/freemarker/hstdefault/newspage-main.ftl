<#include "../include/imports.ftl">

<#-- @ftlvariable name="document" type="nl.avans.beans.NewsDocument" -->
<#if document??>
    <@hst.link var="link" hippobean=document/>

<div class="news-item__header">
  <div class="component-header">
    <div class="container">
      <div class="row">
        <div class="col-xs-12">
          <h2>${document.title}</h2>
          <span class="news-item__type">Nieuws</span><span class="news-item__date"> -
            <@fmt.formatDate value=document.date.time type="date" dateStyle="short" pattern="dd-MM-yyyy"/>
        </span>
        </div>
      </div>
    </div>
  </div>
</div>

<div class="container">
  <div class="row">

    <div class="news-item__content">

      <img src="<@hst.link hippobean=document.image/>" alt="${document.image.description}">

        <@hst.html hippohtml=document.content/>

    </div>

  </div>
</div>

</#if>