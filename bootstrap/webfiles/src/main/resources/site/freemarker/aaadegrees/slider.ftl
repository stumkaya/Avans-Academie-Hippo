<#include "../include/imports.ftl">

<#-- @ftlvariable name="componentId" type="java.lang.String" -->
<#-- @ftlvariable name="item" type="nl.avans.beans.Banner" -->
<#-- @ftlvariable name="pageable" type="org.onehippo.cms7.essentials.components.paging.Pageable" -->
<#-- @ftlvariable name="cparam" type="org.onehippo.cms7.essentials.components.info.EssentialsCarouselComponentInfo" -->
<#if pageable?? && pageable.items?has_content>

<div class="component-slider">
  <div class="slider">
    <div class="skew-container">
        <#list pageable.items as item>
          <div class="slide">
            <figure class="slide-img">
              <img src="<@hst.link hippobean=item.image />" alt="<#if item.image.description??>${item.image.description?html}</#if>"/>123
              <figcaption><#if item.title??>${item.title}</#if></figcaption>
            </figure>
          </div>
        </#list>
    </div>
  </div>
  <div class="slider-controls">
    <a href=# class="ctrl-prev"><span>Prev</span></a>
    <a href=# class="ctrl-next"><span>Next</span></a>
  </div>
</div>

    <@hst.headContribution category="htmlBodyEnd">
    <script type="text/javascript" src="<@hst.webfile path="/js/vendor/jquery.min.js"/>"></script>
    </@hst.headContribution>

    <@hst.headContribution category="htmlBodyEnd">
    <script type="text/javascript" src="<@hst.webfile path="/js/vendor/bootstrap.min.js"/>"></script>
    </@hst.headContribution>

    <@hst.headContribution category="htmlBodyEnd">
    <script type="text/javascript" src="<@hst.webfile path="/js/vendor/jquery.cycle2.min.js"/>"></script>
    </@hst.headContribution>

    <@hst.headContribution category="htmlBodyEnd">
    <script type="text/javascript" src="<@hst.webfile path="/js/vendor/scrollspy.js"/>"></script>
    </@hst.headContribution>

    <@hst.headContribution category="htmlBodyEnd">
    <script type="text/javascript" src="<@hst.webfile path="/js/scripts.min.js"/>"></script>
    </@hst.headContribution>



    <#if editMode>
    <script type="text/javascript">
      if (window.jQuery && window.jQuery.fn.carousel) {
        jQuery('#${componentId}').carousel();
      }
    </script>
    </#if>

<#elseif editMode>
<img src="<@hst.link path='/images/essentials/catalog-component-icons/carousel.png'/>"> Click to edit Carousel
</#if>
