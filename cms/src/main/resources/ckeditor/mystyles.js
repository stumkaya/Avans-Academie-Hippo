(function () {
  "use strict";

  CKEDITOR.stylesSet.add('mystyle', [
    {
      element: 'a',
      name: 'Button',
      attributes: {
        class: 'btn btn-primary'
      }
    },
    {
      element: 'a',
      name: 'Link',
      attributes: {
        class: 'link'
      }
    },
    {
      element: 'ul',
      name: 'Checked List',
      attributes: {
        class: 'checked-list'
      }
    },

    {
      element: 'address',
      name: 'Adres'
    },
    {
      element: 'h1',
      name: 'Kop 1'
    },
    {
      element: 'h2',
      name: 'Kop 2'
    },
    {
      element: 'h3',
      name: 'Kop 3'
    },
    {
      element: 'h4',
      name: 'Kop 4'
    },
    {
      element: 'h5',
      name: 'Kop 5'
    },
    {
      element: 'h6',
      name: 'Kop 6'
    },
    {
      element: 'p',
      name: 'Normaal'
    },
    {
      element: 'pre',
      name: 'Voorgedefinieerd'
    }
  ])
}());