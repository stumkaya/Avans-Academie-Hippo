<#include "../include/imports.ftl">

<#-- @ftlvariable name="item" type="nl.avans.beans.NewsDocument" -->
<#-- @ftlvariable name="pageable" type="org.onehippo.cms7.essentials.components.paging.Pageable" -->


<div class="header-row">
  <div class="component-header">
    <div class="container">
      <div class="row">
        <div class="col-xs-12">
          <h1>Nieuws</h1>
        </div>
      </div>
    </div>
  </div>
</div>



<#if pageable?? && pageable.items?has_content>

<div class="container">
  <div class="row">

    <div class="col-xs-12 col-sm-8">


    <#list pageable.items as item>
        <@hst.link var="link" hippobean=item />

      <a class="news" href="${link}">
        <div class="news__image" style="background-image: url('<@hst.link hippobean=item.image/>');"></div>
        <div class="news__body">
          <span class="news__type">Nieuws - </span>
          <span class="news__date">
              <@fmt.formatDate value=item.date.time type="date" dateStyle="medium"/>
          </span>
          <span class="news__title">${item.title}</span>
        </div>
      </a>
    </#list>
    <#if cparam.showPagination>
        <#include "../include/pagination.ftl">
    </#if>
    </div>
  </div>
</div>
<#-- @ftlvariable name="editMode" type="java.lang.Boolean"-->
<#elseif editMode>
    <img src="<@hst.link path='/images/essentials/catalog-component-icons/news-list.png'/>"> Click to edit News List
</#if>


