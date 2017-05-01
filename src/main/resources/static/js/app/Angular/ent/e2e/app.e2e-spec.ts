import {EntPage} from "./app.po";

describe('ent App', () => {
  let page: EntPage;

  beforeEach(() => {
    page = new EntPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
