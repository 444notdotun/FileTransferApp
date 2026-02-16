package urlshortner.urlshortner.service;

public interface UrlShortnerService  {
    String shortUrl(String OriginalUrl);
    String RedirectShortUrl(String shortUrlCode);
}
